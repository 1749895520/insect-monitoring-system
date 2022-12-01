<template>
  <div class="app-container home">
    <el-card class="box-card">
      <el-row style="height: 100%;width: 100%">
        <el-col :span="24" style="display: flex;justify-content: space-between;padding: 10px">
          <el-row style=";background-color: #fff;width: 100%;height: 50px;border:#f3f4f5 solid 1px;">
            <el-col :span="8" style="display: flex;justify-content: left;border-bottom: 1px solid transparent">
              <el-button
                v-show="imgOrTest"
                type="primary"
                icon="el-icon-picture-outline"
                size="small" plain style="margin: 7px 5px 0 10px"
                @click="$router.push('/monitor/druid')">图片管理
              </el-button>
              <el-button
                v-show="imgOrTest"
                type="danger"
                @click="isDeleteDialog = true"
                icon="el-icon-delete"
                size="small" plain style="margin: 7px 5px 0 10px">清空图片
              </el-button>
              <el-button
                v-show="imgOrTest"
                type="success" size="small"
                icon="el-icon-edit"
                @click="isRunDialog = true"
                plain style="margin: 7px 5px 0 10px">开始检测
              </el-button>
              <el-button
                v-show="!imgOrTest"
                type="primary"
                icon="el-icon-more-outline"
                size="small" plain style="margin: 7px 5px 0 10px"
                @click="$router.push('/monitor/cache')">查看详情
              </el-button>
              <el-button
                v-show="!imgOrTest"
                plain
                type="warning"
                icon="el-icon-download"
                size="small"
                style="margin: 7px 5px 0 10px"
                @click="exportDialogVisible = true">
                批量下载
              </el-button>
            </el-col>
            <el-col :span="8" style="display: flex;justify-content: center">
              <el-button type="warning" size="small" :plain="imgOrTest"
                         style="margin: 7px 0 0 0;border-radius: 20px 0 0 20px"
                         :disabled="imgOrTest"
                         @click="changeWin()">待检测图片
              </el-button>
              <el-button type="warning" size="small" :plain="!imgOrTest"
                         style="margin: 7px 0 0 0;border-radius: 0 20px 20px 0"
                         :disabled="!imgOrTest"
                         @click="changeWin()">检测后图片
              </el-button>
            </el-col>
            <el-col :span="8" style="display: flex;justify-content: center;padding-top: 8px">
              <el-input
                suffix-icon="el-icon-search"
                class="front-search-input"
                style="width: 200px;border-radius: 20px 0 0 20px !important;"
                size="small"
                placeholder="请输入要查找的图片名"
                v-model="filename"></el-input>
              <el-button style="margin-left: 30px"
                         type="primary"
                         icon="el-icon-search"
                         size="small"
                         @click="load">搜索
              </el-button>
              <el-button style="margin-left: 10px"
                         size="small"
                         icon="el-icon-refresh"
                         type="warning"
                         @click="load">重置
              </el-button>
            </el-col>
          </el-row>
        </el-col>
        <el-col v-show="imgOrTest" :span="6" style="height: 620px;padding: 0 10px 60px 10px">
          <div style="width: auto;height: 30px;background-color: #fff;margin-bottom: 10px">
            <p style="margin: 0;padding-top: 2px;font-size: 20px;font-weight: bold;text-align: center">待检测害虫图片</p>
          </div>
          <div class="img-box scrollbox"
               style="background-color: #fff;width: 100%;border: #f3f4f5 solid 1px;height: 580px;">
            <el-row v-show="imgShow" :gutter="10">
              <el-col :span="12"
                      v-for="(item, index) in beforeImgs"
                      :key="index"
                      :class="{'img-focus':beforeImgIndex === index}"
                      v-model="beforeImgIndex"
                      style="border: #f3f4f5 solid 1px;width: 50%;">
                <img v-model="beforeImgIndex"
                     @click="changeIndex(index)"
                     :src="beforeImgs[index]" alt=""
                     style="width: 100%;height: auto;padding-top: 4px">
              </el-col>
            </el-row>
          </div>
        </el-col>
        <el-col v-show="!imgOrTest" :span="6" style="height: 620px;padding: 0 10px 60px 10px">
          <div style="width: auto; flex: 1;background-color: #fff;margin-bottom: 10px">
            <el-select
              style="width: 100%;padding: 10px  10px 10px 10px"
              v-model="value"
              @change="selectChange"
              placeholder="请选择历史检测结果"
              value="">
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </div>
          <div class="img-box scrollbox"
               style="background-color: #fff;width: 100%;border: #f3f4f5 solid 1px;height: 554px;">
            <el-row :gutter="10">
              <el-col :span="12"
                      v-for="(item, index) in afterImgs"
                      :key="index"
                      :class="{'img-focus':afterImgIndex === index}"
                      v-model="afterImgIndex"
                      style="border: #f3f4f5 solid 1px;width: 50%;">
                <img v-model="afterImgIndex"
                     @click="changeIndex(index)"
                     :src="afterImgs[index]" alt=""
                     style="width: 100%;height: auto;padding-top: 4px">
              </el-col>
            </el-row>
          </div>
        </el-col>
        <el-col v-show="imgOrTest" :span="18" style="padding: 0 10px 10px 0;">
          <div style="background-color: #fff;width: 100%;height: 620px;border: #f3f4f5 solid 1px;">
            <img v-show="imgShow" v-model="beforeImgIndex" :src="beforeImgs[beforeImgIndex]" alt=""
                 style="width: 100%;height: 600px;padding: 10px">
          </div>
        </el-col>
        <el-col v-show="!imgOrTest" :span="18" style="padding: 0 10px 10px 0;">
          <div style="background-color: #fff;width: 100%;height: 620px;border: #f3f4f5 solid 1px;">
            <img v-model="afterImgIndex" :src="afterImgs[afterImgIndex]" alt=""
                 style="width: 100%;height: 600px;padding: 10px">
          </div>
        </el-col>
      </el-row>
    </el-card>
    <el-dialog
      :modal-append-to-body="false"
      title="提示"
      :visible.sync="isDeleteDialog"
      width="30%">
      <span>确认清空当前图片？</span>
      <span slot="footer" class="dialog-footer">
    <el-button @click="isDeleteDialog = false">我再想想</el-button>
    <el-button type="primary" @click="doDelImg">确 定</el-button>
  </span>
    </el-dialog>
    <el-dialog
      :modal-append-to-body="false"
      title="提示"
      :visible.sync="isRunDialog"
      width="30%">
      <span>确认开始本次检测？</span>
      <span slot="footer" class="dialog-footer">
    <el-button @click="isRunDialog = false">我再想想</el-button>
    <el-button type="primary" @click="doRun">确 定</el-button>
  </span>
    </el-dialog>
    <el-dialog
      :modal-append-to-body="false"
      title="检 测 中"
      :visible.sync="runDialog"
      width="30%">
      <div style="display: flex;justify-content: center">
        <el-progress :color="colors" type="circle" :percentage="progress"></el-progress>
      </div>
      <span slot="footer" class="dialog-footer">
    <el-button @click="runDialog = false">取消</el-button>
  </span>
    </el-dialog>
  </div>
</template>

<script>
import {run} from "@/api/file";

export default {
  name: "Index",
  data() {
    return {
      // 版本号
      version: "3.8.4",
      beforeImgs: [],
      beforeImgNames: [],
      beforeImgIndex: 0,
      afterImgs: [],
      afterImgNames: [],
      afterImgIndex: 0,
      imgOrTest: true,
      isDeleteDialog: false,
      isRunDialog: false,
      runDialog: false,
      isRunOver: false,
      imgShow: true,
      filename: '',
      value: 'exp6',
      progress: 0,
      options: [
        {
          label: 'exp',
          value: 'exp',
        },
        {
          label: 'exp2',
          value: 'exp2',
        },
        {
          label: 'exp3',
          value: 'exp3',
        },
        {
          label: 'exp4',
          value: 'exp4',
        },
        {
          label: 'exp5',
          value: 'exp5',
        },
        {
          label: 'exp6',
          value: 'exp6',
        }
      ],
      colors: [
        {color: '#f56c6c', percentage: 20},
        {color: '#e6a23c', percentage: 40},
        {color: '#6f7ad3', percentage: 60},
        {color: '#1989fa', percentage: 80},
        {color: '#5cb87a', percentage: 100}
      ],
      exportDialogVisible: false,
      time: 0,
    };
  },
  created() {
    this.getAfterImgs("D:\\ZFiend\\Project\\RuoYi-Vue-master\\runs\\detect\\" + (this.value + ''))
  },
  activated() {
    this.imgShow = true
  },
  mounted() {
    let imgList = []
    const files = require.context("@/../../data/images", true, /\.*\.jpg|jpeg|png$/).keys()
    files.forEach((e) => {
      this.beforeImgNames.push(e.substring(2))
      imgList.push(require("../../../data/images" + e.slice(1)))
    })
    this.beforeImgs = imgList
  },
  methods: {
    getAfterImgs(path) {
      let imgList = []
      const files = require.context("@/../../runs/detect/exp", true, /\.*\.jpg|jpeg|png$/).keys()
      files.forEach((e) => {
        this.afterImgNames.push(e.substring(2))
        imgList.push(require("../../../runs/detect/exp" + e.slice(1)))
      })
      this.afterImgs = imgList
      return imgList
    },
    selectChange() {
      console.log(this.value)
      this.getAfterImgs("@/../../runs/detect/" + (this.value + ''))
    },
    changeWin() {
      this.imgOrTest = !this.imgOrTest
    },
    getName(nameStr) {
      if (nameStr.length > 25) {
        return nameStr.substring(0, 25) + "..."
      }
      return nameStr
    },
    goTarget(href) {
      window.open(href, "_blank");
    },
    handleOpenMenu() {
      const file = document.getElementById('file')
      file.click()
    },
    fileChange(e) {
      try {
        const fu = document.getElementById('file')
        if (fu === null) return
        // 只有electro可以获取到文件夹路径
        this.form.collectPath = fu.files[0].path.replaceAll('\\', '/')
      } catch (error) {
        console.debug('choice file err:', error)
      }
    },
    load() {
    },
    changeIndex(index) {
      this.beforeImgIndex = index
      this.afterImgIndex = index
    },
    start() {
      run().then(e => {
        console.log('启动检测')
      })
    },
    doDelImg() {
      this.imgShow = false
      this.isDeleteDialog = false
      this.$message.success("删除成功")
    },
    doRun() {
      this.progress = 0
      this.isRunDialog = false
      this.runDialog = true
      this.pro()
      this.pro()
      this.pro()
      this.pro()
      this.pro()
      this.pro()
      this.pro()
      this.pro()
      this.pro()
      this.pro()
      this.pro()
      this.pro()
      this.pro()
      setTimeout(() => {
        this.progress = 100
        setTimeout(() => {
          this.runDialog = false
          this.imgOrTest = false
          this.$message.success("检测完成")
        }, 500)
      }, this.time + 2000)
    },
    pro() {
      let num = Math.ceil(Math.random() * 10)
      this.time += Math.random() * 2000
      setTimeout(() => {
        this.progress += num
      }, this.time)
    }
  },
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

.img-focus {
  background-color: #c6e2ff;
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

.home {

  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }

  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }

  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }

    .front-search {
      display: flex;
      justify-content: center;
      margin: 12px;
      border-radius: 20px 0 20px 0;
      position: absolute;
      right: 20%;
    }

    .front-search-input {
      .el-input__inner {
        border-radius: 20px 0 0 20px !important;
      }
    }

    .front-search-button {
      border-radius: 0 20px 20px 0 !important;
    }

    .button-publish {
      border-radius: 20px;
      width: 80px;
    }
  }
}
</style>

