<template>
  <div class="app-container">
    <el-card class="box-card">
      <el-row style="height: 100%;width: 100%">
        <el-col :span="24" style="display: flex;justify-content: space-between;padding: 10px">
          <el-row style=";background-color: #fff;width: 100%;height: 50px;border:#f3f4f5 solid 1px;">
            <el-col :span="10" style="display: flex;justify-content: left">
              <el-upload
                accept=".jpg"
                :headers="headers"
                :ref="fileList"
                :show-file-list="false"
                :file-list="fileList"
                :on-preview="handlePreview"
                :on-success="success"
                :on-remove="handleRemove"
                :before-remove="beforeRemove"
                :before-upload="beforeUpload"
                :on-change="onChange"
                :action="'http://' + serverIp + ':8080/file/upload/JPEG'">
                <el-button
                  slot="trigger"
                  plain
                  type="primary"
                  icon="el-icon-circle-plus-outline"
                  size="small"
                  style="margin: 7px 5px 0 10px">
                  上传图片
                </el-button>
              </el-upload>
              <el-button plain type="danger" icon="el-icon-delete" size="small"
                         style="margin: 7px 5px 0 10px" @click="delAllDialogVisible = true">
                批量删除
              </el-button>
              <el-button plain type="success" icon="el-icon-circle-check" size="small"
                         style="margin: 7px 5px 0 10px" @click="selectAllDialogVisible = true">
                批量选中
              </el-button>
              <el-button
                plain
                type="warning"
                icon="el-icon-download"
                size="small"
                style="margin: 7px 5px 0 10px"
                @click="downloadAllDialogVisible = true">
                批量下载
              </el-button>
            </el-col>
            <el-col :span="4" style="display: flex;justify-content: center;padding-top: 8px">
              <div style="padding: 5px 0 3px 0;font-weight: bold;">图 片 数 据</div>
            </el-col>
            <el-col :span="10" style="display: flex;justify-content: right;padding-top: 8px">
              <el-input suffix-icon="el-icon-search"
                        class="front-search-input"
                        style="width: 200px;border-radius: 20px 0 0 20px !important;"
                        size="small"
                        placeholder="请输入要查找的图片名"
                        v-model="name"
              />
              <el-button
                style="margin-left: 10px"
                type="primary"
                icon="el-icon-search"
                size="small">
                搜索
              </el-button>
              <el-button style="margin: 0 10px 0 10px"
                         size="small"
                         icon="el-icon-refresh"
                         type="warning"
                         @click="load">重置
              </el-button>
            </el-col>
          </el-row>
        </el-col>
        <el-col :span="24" style="display: flex;justify-content: space-between;padding: 0 10px 10px 10px">
          <div style="background-color: #fff; padding: 10px;width: 100%;height: 100%">
            <el-table :data="tableData"
                      highlight-current-row
                      stripe
                      style="width: 100%;"
                      @selection-change="handleSelectionChange"
                      fit
                      height="600">
              <el-table-column type="selection" width="55px">
              </el-table-column>
              <el-table-column sortable prop="id" label="ID" width="80px">
              </el-table-column>
              <el-table-column sortable prop="name" label="名称" min-width="100px">
              </el-table-column>
              <el-table-column sortable prop="time" label="上传时间" min-width="100px">
              </el-table-column>
              <el-table-column prop="type" label="类型" min-width="50px">
              </el-table-column>
              <el-table-column prop="size" label="大小(kb)" min-width="50px">
              </el-table-column>
              <el-table-column label="操作" width="300px" fixed="right">
                <template slot-scope="scope">
                  <div>
                    <el-button size="mini" type="primary" @click="handleEdit(scope.row)">查看</el-button>
                    <el-button size="mini" type="danger" @click="isDel(scope.row.id)">删除</el-button>
                    <el-button size="mini" type="success" @click="isDel(scope.row.id)">选中</el-button>
                    <el-button size="mini" type="warning" @click="isDel(scope.row.id)">下载</el-button>
                  </div>
                </template>
              </el-table-column>
            </el-table>
          </div>
        </el-col>
      </el-row>
    </el-card>
    <el-dialog
      :modal-append-to-body="false"
      title="提示"
      :visible.sync="selectAllDialogVisible"
      width="30%">
      <span>确认批量选中当前图片？</span>
      <span slot="footer" class="dialog-footer">
    <el-button @click="selectAllDialogVisible = false">我再想想</el-button>
    <el-button type="primary" @click="selectSuccess">确 定</el-button>
  </span>
    </el-dialog>
  </div>
</template>
<script>
import {imgList, serverIp} from "@/api/file";
import {getToken} from "@/utils/auth";

export default {
  name: "Druid",
  data() {
    return {
      serverIp: serverIp,
      name: '',
      detectName: undefined,
      delAllDialogVisible: false,
      selectAllDialogVisible: false,
      downloadAllDialogVisible: false,
      tableData: [],
      fileList: [],
      headers: {
        Authorization: "Bearer " + getToken(),
      },
      uploadPath: 'http://localhost:8080/file/upload/JPEG',
    };
  },
  created() {
    this.load()
    this.loadList()
  },
  methods: {
    load() {
      this.tableData = []
      imgList().then(i => {
        this.tableData = i.data
        console.log(this.tableData)
      })
    },
    loadList() {
      this.fileList = []

    },
    handleAdd() {
      console.log(this.fileList)
    },
    handleSelectionChange() {

    },
    handleEdit() {

    },
    isDel() {

    },
    handlePreview() {

    },
    success() {
      this.$message.success('图片上传成功')
    },
    handleRemove() {

    },
    beforeRemove() {

    },
    beforeUpload() {

    },
    onChange() {
      this.load()
    },
    selectSuccess() {
      this.selectAllDialogVisible = false
      this.$router.replace('/index')
    }
  }
};
</script>
<style scoped lang="scss">
::v-deep {
  .el-radio-group {
    display: block;
    background-color: #ffffff;
    padding: 0;

    .el-radio {
      color: #000000;
    }

    .is-checked {
      background-color: #c6e2ff;
    }
  }

  .el-radio-group:hover {
    background-color: #ecf5ff;
  }


  .scrollbox {
    height: 100%;
    width: 100%;
    overflow: auto;
    // 滚动条整体部分
    &::-webkit-scrollbar {
      width: 6px; //对垂直方向滚动条
      height: 6px; //对水平方向滚动条
    }

    //滚动的滑块
    &::-webkit-scrollbar-thumb {
      border-radius: 3px;
      background-color: #ccc //滚动条的颜色
    }

    //内层滚动槽
    &::-webkit-scrollbar-track-piece {
      background-color: #ccc;
    }
  }

  .el-card {
    background-color: #ecf5ff;

    .el-card__body {
      padding: 0;
      height: 100%;
      width: 100%;
    }
  }

  .el-radio__input {
    display: none;
  }
}

.box-card {
  display: flex;
  height: 700px;
}

.img-box {
  flex: 1;
  background-color: #fff;
  height: 620px;
  width: auto;
  border-right: 1px solid #2b2b2b;
  padding: 10px;

  ::-webkit-scrollbar {
    display: none;
  }
}
</style>
