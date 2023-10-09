<template>
  <el-card>
    <el-row :gutter="20" class="header">
      <el-col :span="7">
        <el-input placeholder="请输入用户名或者用户ID" clearable v-model="queryForm.query">
        </el-input>
      </el-col>
      <el-button type="primary" :icon="Search" @click="initGetUserList">搜索</el-button>
      <el-button type="primary" @click="handldeDialogValue('add')">添加用户</el-button>
    </el-row>
    <el-table :data="tableData" stripe style="width: 100%">
      <el-table-column :prop="item.prop" :label="item.label" :key="index" width="180" v-for="(item,index) in options"/>
      <el-table-column prop="action" label="action">
        <template #default="{row}">
          <el-button type="primary" :icon="Edit" circle  @click="handldeDialogValue(row)"/>
          <el-button type="danger" :icon="Delete" circle @click="delUser(row)"/>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
        v-model:current-page="queryForm.pagenum"
        v-model:page-size="queryForm.pagesize"
        :page-sizes="[1, 2, 4, 6]"
        layout="total, sizes, prev, pager, next, jumper"
        :total="queryForm.total"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
    />
  </el-card>
  <Dialog v-model="dialogVisible"
          :dialogTitle="dialogTitle"
          v-if="dialogVisible"
          @initUserList="initGetUserList"
          :dialogTableValue="dialogTableValue">

  </Dialog>
</template>

<script setup>
import { ref } from 'vue'
import { Search, Edit, Delete } from '@element-plus/icons-vue'
import { getUserList,deleteUser } from "@/api/user";
import { options } from "@/views/options";
import Dialog from "@/views/components/dialog.vue"
import { isNull } from '@/api/commons'

const dialogVisible = ref(false)
const dialogTitle = ref('')
const dialogTableValue = ref({})
const queryForm = ref({
  query: '',
  pagenum: 1,
  pagesize: 6,
  total:0,
})
const tableData = ref([])

const initGetUserList = async () => {
  const res = await getUserList(queryForm.value)
  tableData.value = res.data.records
  queryForm.value.total = res.data.total

}
initGetUserList()
const handleSizeChange = (pageSize) => {
  queryForm.value.pagenum = 1
  queryForm.value.pagesize = pageSize
  initGetUserList()
}
const handleCurrentChange = (pageNum) => {
  queryForm.value.pagenum = pageNum
  initGetUserList()
}
const handldeDialogValue = (row) => {
  if (row === 'add') {
    dialogTitle.value = '添加用户'
  } else{
    dialogTitle.value = '编辑用户'
    dialogTableValue.value = JSON.parse(JSON.stringify(row))
  }
  dialogVisible.value = true
}
const delUser = (row) => {
  ElMessageBox.confirm(
      '确定要删除该用户吗?',
      '警告',
      {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
      }
  )
      .then(() => {
        deleteUser(row)
        initGetUserList()
        ElMessage({
          type: 'success',
          message: '删除成功',
        })
      })
      .catch(() => {
        ElMessage({
          type: 'info',
          message: '取消删除',
        })
      })
}
</script>

<style lang="scss" scoped>
.header{
  padding: 16px;
  box-sizing: border-box;
}

::v-deep .el-pagination{
  padding-top: 16px;
  box-sizing: border-box;
  text-align: right;
}
</style>
