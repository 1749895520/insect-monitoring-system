<template>
  <div class="app-container">
    <el-card class="box-card">
      <el-row style="height: 100%;width: 100%">
        <el-col :span="24" style="display: flex;justify-content: space-between;padding: 10px">
          <el-row style=";background-color: #fff;width: 100%;height: 50px;border:#f3f4f5 solid 1px;">
            <el-col :span="10" style="display: flex;justify-content: left">
              <el-button
                type="primary"
                size="small" icon="el-icon-picture-outline" plain style="margin: 7px 5px 0 10px"
                @click="$router.push('/index')">查看图片
              </el-button>
              <el-button plain type="danger" icon="el-icon-delete" size="small"
                         style="margin: 7px 5px 0 10px">
                移除检测
              </el-button>
              <el-button
                plain
                type="warning"
                icon="el-icon-download"
                size="small"
                style="margin: 7px 5px 0 10px">
                导出检测
              </el-button>
            </el-col>
            <el-col :span="4" style="display: flex;justify-content: center;padding-top: 8px">
              <div style="padding: 5px 0 3px 0;font-weight: bold;">虫 情 监 控</div>
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
        <el-col :span="24">
          <el-row :gutter="10" style="height: 100%; width: 100%">
            <el-col :span="8" style="height: 100%">
              <div style="background-color: #fff; padding: 10px;width: 100%;height: 620px">
                <div style="font-size: 24px;font-weight: bold;text-align: center">
                  害虫种类数量饼图
                </div>
                <div style="width: 100%; height: 75%"
                     id="PI"
                     class="box-echarts-body"/>
              </div>
            </el-col>
            <el-col :span="8">
              <div style="background-color: #fff; padding: 10px;width: 100%;height: 620px">
                <div style="font-size: 24px;font-weight: bold;text-align: center">
                  虫情预警及防治措施
                </div>
                <div v-show="textShow" style="font-size: 16px;margin-top: 10px;text-indent: 2em">
                  当前虫害情况为 <span style="color: orange; font-weight: bold">一般</span>：
                  <el-progress :percentage="process" :color="color"
                               style="width: 80%;margin-left: 30px;margin-top: 10px"></el-progress>
                  <div style="font-weight: bold;margin-top: 30px">
                    防治措施
                  </div>
                  <div style="padding: 20px">
                    <el-collapse v-model="activeNames" accordion>
                      <el-collapse-item title="二化螟 striped rice borer" name="1">
                        <div>
                          农业防治。主要采取消灭越冬虫源、灌水灭虫、避害等措施。
                        </div>
                        <div>
                          药剂防治。为充分利用卵期天敌，应尽量避开卵孵盛期用药。
                        </div>
                        <div>
                          黑光灯诱集二化螟成虫,可诱集到大量的二化螟雌蛾( 由于雌蛾对黑光灯的趋性更强)。
                        </div>
                        <div>
                          增施硅酸肥料。
                        </div>
                      </el-collapse-item>
                      <el-collapse-item title="稻纵卷叶螟 Rice leaf roller" name="2">
                        <div>
                          农业防治：清除杂草；利用水稻抗性选用抗病虫高产良种，结合合理施肥；抓紧夏收，减少第三代虫源；灌水灭蛹。
                        </div>
                        <div>
                          生物防治：天敌。稻纵卷叶螟绒茧蜂；以茵治虫。用杀螟杆菌、青虫菌等细菌农药防治稻纵卷叶螟。
                        </div>
                        <div>
                          灯光防治：利用昆虫的趋光性，点黑光灯诱杀害虫。
                        </div>
                        <div>
                          人工防治：在蛾子盛发期间，在晨露未千时，对蛾子密集的地方用涂肥皂水的脸盆或捕虫网捕杀蛾子；早稻收获期遇到第二代蛾子盛发期，利用蛾子趋荫蔽栖息的习性，随收刈进展，把蛾子赶到田角用药消灭。
                        </div>
                      </el-collapse-item>
                      <el-collapse-item title="蝼蛄 Rmole cricket" name="3">
                        <div>蝼蛄趋光性强，可用黑光灯、水银灯、频振诱虫灯、太阳能诱虫灯诱杀，效果较好，能杀死大量的有效虫源。晴朗无风闷热的天气诱集量最多。</div>
                        <div>
                          从整地到苗期管理，本着预防为主。深翻土地、适时中耕、清除杂草、改良盐碱地、不施用未腐熟的有机肥等，创造不利于害虫发生的环境条件。
                        </div>
                        <div>
                          蝼蛄趋光性强，可用黑光灯、水银灯、频振诱虫灯、太阳能诱虫灯诱杀，效果较好，能杀死大量的有效虫源。晴朗无风闷热的天气诱集量最多。
                        </div>
                        <div>
                          从整地到苗期管理，本着预防为主。深翻土地、适时中耕、清除杂草、改良盐碱地、不施用未腐熟的有机肥等，创造不利于害虫发生的环境条件。
                        </div>
                        <div>
                          在春季苏醒尚未迁移时，扒开虚土堆扑杀。蝼蛄可以食用和药用，做好广泛的宣传，可调动广大群众人工捕 捉的积极性，发挥更大作用（但也不能食用过多，蝼蛄有小毒）；结合灯光诱集后人工捕杀效果更好。
                        </div>
                      </el-collapse-item>
                      <el-collapse-item title="大螟 Sesamia inferens" name="4">
                        <div>
                          对第一代进行测报，通过查上一代化蛹进度，预测成虫发生高峰期和第一代幼虫孵化高峰期，报出防治适期。
                        </div>
                        <div>
                          有茭白的地区冬季或早春齐泥割除茭白残株，铲除田边杂草，消灭越冬螟虫。
                        </div>
                      </el-collapse-item>
                      <el-collapse-item title="稻蓟马 Chloethrips oryzae" name="5">
                        <div>
                          农业防治：调整种植制度，尽量避免水稻早、中、晚混栽，相对集中播种期和栽秧期，以减少稻蓟马的繁殖桥梁田和辗转为害的机会。合理施肥，在施足基肥的基础上，适期适量追施返青肥，促使秧苗正常生长，减轻为害。防止乱施肥。
                        </div>
                        <div>
                          化学防治：防治时期：依据稻蓟马的发生为害规律，遭受稻蓟马的为害时期，一是秧苗四、五叶期用药一次，二是本田稻苗返青期。这两个时期应是保护的重点。即在秧田秧苗四、五叶期用药一次，第二次在秧苗移栽前2－3天用药。
                        </div>
                      </el-collapse-item>
                      <el-collapse-item title="蚊 Mosquito" name="6">
                        <div>
                          清除和破坏孳生点，各类容器积水，是蚊虫的主要孳生场所。
                        </div>
                        <div>
                          杀孑孓药物的投放，在下水道等水域投放杀孑孓药物，从根源上消灭蚊虫。倍硫磷毒性较大，不宜在室内使用，双硫磷可以在饮用水中使用。
                        </div>
                      </el-collapse-item>
                    </el-collapse>
                  </div>
                </div>
              </div>
            </el-col>
            <el-col :span="8" style="height: 100%;">
              <div style="background-color: #fff; padding: 10px;width: 100%;height: 620px">
                <div style="font-size: 24px;font-weight: bold;text-align: center">
                  历次检测害虫总数折线图
                </div>
                <div style="width: 100%; height: 75%"
                     id="PI2"
                     class="box-echarts-body"/>
              </div>
            </el-col>
          </el-row>
        </el-col>
      </el-row>
    </el-card>
  </div>
</template>

<script>

import {detectList} from "@/api/detect";
import * as echarts from 'echarts';

export default {
  name: "Cache",
  data() {
    return {
      detectName: undefined,
      tableData: [],
      detects: [],
      id: '',
      name: '',
      time: '',
      textShow: false,
      process: 55,
      color: [
        {color: '#06ec12', percentage: 30},
        {color: '#f69a11', percentage: 60},
        {color: '#f60707', percentage: 90},
      ],
      activeNames: '',
    }
  },
  created() {
    this.load()
    setTimeout(() => {
      this.textShow = true
    }, 1000)
  },
  mounted() {
    setTimeout(() => {
      let chartDom = document.getElementById('PI');
      let myChart = echarts.init(chartDom);
      let option = {

        tooltip: {
          trigger: 'item'
        },
        legend: {
          top: '5%',
          left: 'center'
        },
        series: [
          {
            name: 'Access From',
            type: 'pie',
            radius: ['40%', '70%'],
            avoidLabelOverlap: false,
            itemStyle: {
              borderRadius: 10,
              borderColor: '#fff',
              borderWidth: 2
            },
            label: {
              show: false,
              position: 'center'
            },
            emphasis: {
              label: {
                show: true,
                fontSize: '24',
                fontWeight: 'bold'
              }
            },
            labelLine: {
              show: true
            },
            data: [
              {value: 197, name: '蚊'},
              {value: 110, name: '稻蓟马'},
              {value: 94, name: '其他'},
              {value: 42, name: '大螟'},
              {value: 19, name: '二化螟'},
              {value: 3, name: '稻纵卷叶螟'},
              {value: 2, name: '蝼蛄'}
            ]
          }
        ]
      };

      option && myChart.setOption(option);

      let chartDom2 = document.getElementById('PI2');
      let myChart2 = echarts.init(chartDom2);
      let option2 = {
        xAxis: {
          type: 'category',
          data: ['exp', 'exp2', 'exp3', 'exp4', 'exp5', 'exp6']
        },
        yAxis: {
          type: 'value'
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'cross',
            label: {
              backgroundColor: '#6a7985'
            }
          }
        },
        series: [
          {
            itemStyle: {normal: {label: {show: true}}},
            data: [111, 234, 218, 135, 147, 367],
            type: 'line'
          }
        ]
      };

      option2 && myChart2.setOption(option2);

    }, 1000)
  },
  methods: {
    load() {
      detectList().then(e => {
        console.log(e)
        this.tableData = e.data
      })
    },
    handleSelectionChange() {

    },
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

.title {
  //text-align: center;

  font-weight: bold;
  font-size: 20px;
}

.el-table {
  .cell {
    text-align: center;
  }
}

.box-echarts-body {
  font: inherit;
  vertical-align: baseline;
  display: block;
}

</style>
