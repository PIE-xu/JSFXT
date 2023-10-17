<template>
  <div class="container">
    <!-- 左侧表单 -->
    <div class="left-container">
    <!-- 健身房信息管理表单 -->
    <el-form :model="gymClub" :rules="gymClubRules" ref="gymClubForm" label-width="80px" style="width: 70%;">
      <h2 style="margin-bottom: 20px;">健身房信息修改</h2>
      <el-form-item label="ID">
        <el-input v-model="gymClub.id" :disabled="true"></el-input>
      </el-form-item>
      <el-form-item label="名称">
        <el-input v-model="gymClub.name"></el-input>
      </el-form-item>
      <el-form-item label="简介">
        <el-input v-model="gymClub.description"></el-input>
      </el-form-item>
      <el-form-item label="国家">
        <el-input v-model="gymClub.country"></el-input>
      </el-form-item>
      <el-form-item label="城市">
        <el-input v-model="gymClub.city"></el-input>
      </el-form-item>
      <el-form-item label="街道地址">
        <el-input v-model="gymClub.streetAddress"></el-input>
      </el-form-item>
      <el-form-item label="联系电话">
        <el-input v-model="gymClub.phone"></el-input>
      </el-form-item>
      <el-form-item label="营业时间">
        <el-input v-model="gymClub.businessHours"></el-input>
      </el-form-item>
      <el-form-item label="用户平均评分">
        <el-input v-model="gymClub.averageRating"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="saveGymClub">保存</el-button>
      </el-form-item>
    </el-form>
    </div>

    <!-- 右侧表格容器 -->
    <div class="right-container">

    <!-- 教练信息表格 -->
      <h3>教练信息</h3>
    <el-button type="primary" @click="showAddCoachDialog">新增教练</el-button>
    <el-table
        :data="coaches"
        style="width: 100%"
        v-loading="coachLoading"
        @selection-change="handleCoachSelectionChange"
    >
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column prop="id" label="ID" width="80"></el-table-column>
      <el-table-column prop="name" label="姓名"></el-table-column>
      <el-table-column prop="contactInfo" label="联系信息"></el-table-column>
      <el-table-column prop="qualifications" label="资质"></el-table-column>
      <el-table-column label="操作" width="150">
        <template slot-scope="scope">
          <el-button type="text" @click="editCoach(scope.row)">编辑</el-button>
          <el-button type="text" @click="deleteCoach(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 健身器材表格 -->
      <h3>健身器材信息</h3>
    <el-button type="primary" @click="showAddEquipmentDialog">新增健身器材</el-button>
    <el-table
        :data="equipment"
        style="width: 100%"
        v-loading="equipmentLoading"
        @selection-change="handleEquipmentSelectionChange"
    >
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column prop="id" label="ID" width="80"></el-table-column>
      <el-table-column prop="name" label="名称"></el-table-column>
      <el-table-column prop="description" label="描述"></el-table-column>
      <el-table-column prop="quantity" label="数量"></el-table-column>
      <!-- 其他列配置 ... -->
      <el-table-column label="操作" width="150">
        <template slot-scope="scope">
          <el-button type="text" @click="editEquipment(scope.row)">编辑</el-button>
          <el-button type="text" @click="deleteEquipment(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    </div>
    <!-- 新增教练对话框 -->
    <el-dialog
        title="新增教练"
        :visible="addCoachDialogVisible"
        @close="addCoachDialogVisible = false"
    >
      <!-- 教练新增表单 -->
      <el-form :model="newCoach" :rules="coachRules">
        <el-form-item label="姓名" prop="name">
          <el-input v-model="newCoach.name"></el-input>
        </el-form-item>
        <el-form-item label="联系信息" prop="contactInfo">
          <el-input v-model="newCoach.contactInfo"></el-input>
        </el-form-item>
        <el-form-item label="资质" prop="qualifications">
          <el-input v-model="newCoach.qualifications"></el-input>
        </el-form-item>
      </el-form>
      <!-- 保存和取消按钮 -->
      <span slot="footer" class="dialog-footer">
        <el-button @click="addCoachDialogVisible = false">取消</el-button>
        <el-button type="primary" @click="addCoach">保存</el-button>
      </span>
    </el-dialog>

    <!-- 新增健身器材对话框 -->
    <el-dialog
        title="新增健身器材"
        :visible="addEquipmentDialogVisible"
        @close="addEquipmentDialogVisible = false"
    >
      <!-- 健身器材新增表单 -->
      <el-form :model="newEquipment" :rules="equipmentRules">
        <el-form-item label="名称" prop="name">
          <el-input v-model="newEquipment.name"></el-input>
        </el-form-item>
        <el-form-item label="描述" prop="description">
          <el-input v-model="newEquipment.description"></el-input>
        </el-form-item>
        <el-form-item label="数量" prop="quantity">
          <el-input v-model="newEquipment.quantity" type="number"></el-input>
        </el-form-item>
      </el-form>
      <!-- 保存和取消按钮 -->
      <span slot="footer" class="dialog-footer">
        <el-button @click="addEquipmentDialogVisible = false">取消</el-button>
        <el-button type="primary" @click="addEquipment">保存</el-button>
      </span>
    </el-dialog>

  </div>
</template>

<script>
export default {
  data() {
    return {
      gymClub: {
        id: 1,
        name: "",
        description: "",
        country: "",
        city: "",
        streetAddress: "",
        phone: "",
        businessHours: "",
        averageRating: 0,
      },
      gymClubRules: {
        name: [{ required: true, message: "请输入名称", trigger: "blur" }],
      },
      coaches: [], // 存储教练信息
      equipment: [], // 存储健身器材信息
      coachLoading: false, // 加载状态
      equipmentLoading: false, // 加载状态
      selectedCoaches: [], // 选中的教练
      selectedEquipment: [], // 选中的健身器材
      addCoachDialogVisible: false,
      newCoach: {
        name: "",
        contactInfo: "",
        qualifications: "",
      },
      coachRules: {
        name: [{ required: true, message: "请输入姓名", trigger: "blur" }],
        contactInfo: [{ required: true, message: "请输入联系信息", trigger: "blur" }],
        qualifications: [{ required: true, message: "请输入资质", trigger: "blur" }],
      },

      addEquipmentDialogVisible: false,
      newEquipment: {
        name: "",
        description: "",
        quantity: 0,
      },
      equipmentRules: {
        name: [{ required: true, message: "请输入名称", trigger: "blur" }],
        description: [{ required: true, message: "请输入描述", trigger: "blur" }],
        quantity: [
          { required: true, message: "请输入数量", trigger: "blur" },
          { type: "number", message: "数量必须为数字值", trigger: "blur" },
        ],
      }
    };
  },
  methods: {
    // 保存健身房信息
    saveGymClub() {
      // 实现保存逻辑
    },
    // 编辑教练信息
    editCoach(coach) {
      // 实现编辑逻辑
    },
    // 删除教练信息
    deleteCoach(coach) {
      // 实现删除逻辑
    },
    // 编辑健身器材信息
    editEquipment(equipment) {
      // 实现编辑逻辑
    },
    // 删除健身器材信息
    deleteEquipment(equipment) {
      // 实现删除逻辑
    },
    // 处理教练信息选择变化
    handleCoachSelectionChange(selection) {
      this.selectedCoaches = selection;
    },
    // 处理健身器材选择变化
    handleEquipmentSelectionChange(selection) {
      this.selectedEquipment = selection;
    },
    // 显示新增教练对话框
    showAddCoachDialog() {
      this.addCoachDialogVisible = true;
    },
    // 新增教练
    addCoach() {
      // 实现新增教练逻辑
      this.coaches.push({ ...this.newCoach, id: this.coaches.length + 1 });
      this.addCoachDialogVisible = false;
      this.$message.success("新增教练成功");
    },
    // 显示新增健身器材对话框
    showAddEquipmentDialog() {
      this.addEquipmentDialogVisible = true;
    },
    // 新增健身器材
    addEquipment() {
      // 实现新增健身器材逻辑
      this.equipment.push({ ...this.newEquipment, id: this.equipment.length + 1 });
      this.addEquipmentDialogVisible = false;
      this.$message.success("新增健身器材成功");
    },
  },
};
</script>


<style>
.container {
  display: flex;
  align-items: baseline;
}

.left-container {
  width: 60%;
}

.left-container h2 {
  text-align: center;
  margin-top: 20px;
}

.right-container {
  width: 50%;
  margin-right: 100px;
}
</style>
