<template>
  <el-dialog
      :model-value="dialogVisible"
      :title="dialogTitle"
      width="40%"
      @close="handleClose"
  >
    <el-form :model="form" label-width="70px">
      <el-form-item label="用户名">
        <el-input v-model="form.name" />
      </el-form-item>
      <el-form-item label="性别">
        <el-input v-model="form.sex" />
      </el-form-item>
      <el-form-item label="电话号码">
        <el-input v-model="form.tele" />
      </el-form-item>
      <el-form-item label="年龄">
        <el-input v-model="form.age" />
      </el-form-item>
      <el-form-item label="地址">
        <el-input v-model="form.address" />
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="handleClose">取消</el-button>
        <el-button type="primary" @click="handleConfirm">
          确认
        </el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script setup>
import { defineEmits,ref,defineProps,watch } from 'vue'
import { add,update } from '@/api/user'

const props = defineProps({
  dialogTitle:{
    type: String,
    default: '',
    required: true
  },
  dialogTableValue: {
    type: Object,
  }
})


const emits = defineEmits(['update:modelValue','initUserList'])
const handleClose = () => {
  emits('update:modelValue',false)
}
const handleConfirm = async () => {
  if (props.dialogTitle === '添加用户'){
    await add(form.value)
  }else {
    await update(form.value)
  }
  ElMessage({
    showClose: true,
    message: '操作成功',
    type: 'success',
  })
  emits('initUserList')
  handleClose()
}
const form = ref({
  name:'',
  sex:'',
  tele:'',
  age:'',
  address:''
})

watch(
    () => props.dialogTableValue,
    () =>{
      form.value = props.dialogTableValue
    },
    {deep:true,immediate:true}
)
</script>

<style scoped>

</style>