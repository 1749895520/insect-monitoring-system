<template>
  <div class="app-container">
    <el-card class="box-card">
      <el-row style="height: 100%;width: 100%">
        <el-col :span="24" style="display: flex;justify-content: space-between;padding: 10px">
          <el-row style=";background-color: #fff;width: 100%;height: 50px;border:#f3f4f5 solid 1px;">
            <el-col :span="10" style="display: flex;justify-content: left;border-bottom: 1px solid transparent">

            </el-col>
            <el-col :span="4" style="display: flex;justify-content: center;padding-top: 8px">
              <div style="padding: 5px 0 3px 0;font-weight: bold;">害 虫 数 据</div>
            </el-col>
          </el-row>
        </el-col>
        <el-col :span="24" style="display: flex;justify-content: space-between;padding: 0 10px 10px 10px">
          <div style="background-color: #fff; padding: 10px;width: 100%;height: 100%;font-weight: bold">
            <el-collapse accordion @change="handleChange">
              <el-collapse-item title="异跗萤叶甲 Heterotarsal leaf beetle" name="1">
                <p class="p-title">
                  害虫介绍
                </p>
                <div class="p-box">
                  <p class="p-subtitle">
                    成虫
                  </p>
                  <p class="p-context">
                    体长5mm左右，头黑褐色，复眼发达黑色，触角11节丝状，基部4节黄褐色，余黑褐色。前胸暗黄褐色，前缘色较浓，上生小刻点，无黑色斑纹。鞘翅翠绿色，具光泽。足暗黄色。腹部褐色。全体密生褐色细毛。
                  </p>
                  <p class="p-subtitle">
                    卵
                  </p>
                  <p class="p-context">
                    长约0．8mm，椭圆形，表面光滑，黄色。
                  </p>
                  <p class="p-subtitle">
                    幼虫
                  </p>
                  <p class="p-context">
                    末龄幼虫体长12mm，体黄色，11节，头褐色，每节体背具黑褐色斑点排列，中间的斑较大，两侧生2小斑，斑上有刚毛，尾部半椭圆形或扁平状，背面中部凹下，黄褐色，上生细毛。
                  </p>
                  <p class="p-subtitle">
                    蛹
                  </p>
                  <p class="p-context">
                    裸蛹长6mm，黄色。
                  </p>
                </div>
                <p class="p-title">
                  防治措施
                </p>
                <div class="method-box">
                  <el-row>
                    <el-col :span="8">
                      <el-button plain type="primary" icon="el-icon-circle-plus-outline" size="small"
                                 style="margin: 0 5px 5px 10px" @click="handleAdd">
                        新增措施
                      </el-button>
                      <el-button plain type="danger" icon="el-icon-circle-plus-outline" size="small"
                                 style="margin: 0 5px 5px 10px" @click="isDelAll">
                        批量删除
                      </el-button>
                    </el-col>
                    <el-col :span="8" style="border-bottom: 1px solid transparent">

                    </el-col>
                    <el-col :span="8">
                      <el-input
                        suffix-icon="el-icon-search"
                        class="front-search-input"
                        style="width: 200px;border-radius: 20px 0 0 20px !important;"
                        size="small"
                        placeholder="请输入要查找的措施关键字"
                        v-model="searchName"></el-input>
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
                  <el-table
                    :key="refresh"
                    :data="tableData.filter(e => {
                      return e.iid === 1
                    })"
                    highlight-current-row
                    stripe
                    style="width: 100%;"
                    @selection-change="handleSelectionChange"
                    fit
                    height="300"
                  >
                    <el-table-column type="selection" width="55px">
                    </el-table-column>
                    <el-table-column sortable prop="id" label="ID" width="80px">
                    </el-table-column>
                    <el-table-column sortable prop="context" label="措施" min-width="150px">
                    </el-table-column>
                    <el-table-column label="操作" width="200px" fixed="right">
                      <template slot-scope="scope">
                        <div>
                          <el-button size="mini" type="primary" @click="handleEdit(scope.row)">编辑</el-button>
                          <el-button size="mini" type="danger" @click="isDel(scope.row.id)">删除
                          </el-button>
                        </div>
                      </template>
                    </el-table-column>
                  </el-table>
                  <el-pagination
                    class="box-pagination"
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="pageNum"
                    :page-sizes="[5,10]"
                    :page-size="pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="getTotal(1)">
                  </el-pagination>
                </div>
              </el-collapse-item>
              <el-collapse-item title="黑皮蠹 Black bark beetle" name="2">
                <p class="p-title">
                  害虫介绍
                </p>
                <div class="p-box">
                  <p class="p-context">
                    黑皮蠹是一种鞘翅目皮蠹科的昆虫。主要寄生于大米、小麦、玉米、高粱等作物中，除西藏不明外，各地均有发生，是世界性害虫。一般一年一代，以幼虫群集于室内、衣柜、地板砖石缝隙或尘芥杂物内越冬。成虫不食害衣物，仅飞至野外食花蜜、花粉或菌类等。
                  </p>
                </div>
                <p class="p-title">
                  防治措施
                </p>
                <div class="method-box">
                  <el-row>
                    <el-col :span="8">
                      <el-button plain type="primary" icon="el-icon-circle-plus-outline" size="small"
                                 style="margin: 0 5px 5px 10px" @click="handleAdd">
                        新增措施
                      </el-button>
                      <el-button plain type="danger" icon="el-icon-circle-plus-outline" size="small"
                                 style="margin: 0 5px 5px 10px" @click="handleAdd">
                        批量删除
                      </el-button>
                    </el-col>
                    <el-col :span="8" style="border-bottom: 1px solid transparent">

                    </el-col>
                    <el-col :span="8">
                      <el-input
                        suffix-icon="el-icon-search"
                        class="front-search-input"
                        style="width: 200px;border-radius: 20px 0 0 20px !important;"
                        size="small"
                        placeholder="请输入要查找的措施关键字"
                        v-model="$store.state.frontBlogName"></el-input>
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
                  <el-table
                    :data="tableData.filter(e => {
                    return e.iid === 2
                  })"
                    highlight-current-row
                    stripe
                    style="width: 100%;"
                    @selection-change="handleSelectionChange"
                    fit
                    height="300"
                  >
                    <el-table-column type="selection" width="55px">
                    </el-table-column>
                    <el-table-column sortable prop="id" label="ID" width="80px">
                    </el-table-column>
                    <el-table-column sortable prop="context" label="措施" min-width="150px">
                    </el-table-column>
                    <el-table-column label="操作" width="200px" fixed="right">
                      <template slot-scope="scope">
                        <div>
                          <el-button size="mini" type="primary" @click="handleEdit(scope.row)">编辑</el-button>
                          <el-button size="mini" type="danger" @click="isDel(scope.row.id)">删除
                          </el-button>
                        </div>
                      </template>
                    </el-table-column>
                  </el-table>
                  <el-pagination
                    class="box-pagination"
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="pageNum"
                    :page-sizes="[5,10]"
                    :page-size="pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="getTotal(2)">
                  </el-pagination>
                </div>
              </el-collapse-item>
              <el-collapse-item title="二化螟 striped rice borer" name="3">
                <p class="p-title">
                  害虫介绍
                </p>
                <div class="p-box">
                  <p class="p-context">
                    二化螟属鳞翅目，螟蛾科，是我国水稻上危害最为严重的常发性害虫之一，蛀食水稻茎部，为害分蘖期水稻，造成枯鞘和枯心苗；为害孕穗、抽穗期水稻，造成枯孕穗和白穗；为害灌浆、乳熟期水稻，造成半枯穗和虫伤株。为害株田间呈聚集分布，中心明显。国内各稻区均有分布，较三化螟和大螟分布广，但主要以长江流域及以南稻区发生较重，近年来发生数量呈明显上升的态势。二化螟除危害水稻外，还能危害茭白、玉米、高粱、甘蔗、油菜、蚕豆、麦类以及芦苇、稗、李氏禾等杂草。
                  </p>
                </div>
                <p class="p-title">
                  防治措施
                </p>
                <div class="method-box">
                  <el-row>
                    <el-col :span="8">
                      <el-button plain type="primary" icon="el-icon-circle-plus-outline" size="small"
                                 style="margin: 0 5px 5px 10px" @click="handleAdd">
                        新增措施
                      </el-button>
                      <el-button plain type="danger" icon="el-icon-circle-plus-outline" size="small"
                                 style="margin: 0 5px 5px 10px" @click="handleAdd">
                        批量删除
                      </el-button>
                    </el-col>
                    <el-col :span="8" style="border-bottom: 1px solid transparent">

                    </el-col>
                    <el-col :span="8">
                      <el-input
                        suffix-icon="el-icon-search"
                        class="front-search-input"
                        style="width: 200px;border-radius: 20px 0 0 20px !important;"
                        size="small"
                        placeholder="请输入要查找的措施关键字"
                        v-model="$store.state.frontBlogName"></el-input>
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
                  <el-table
                    :data="tableData.filter(e => {
                    return e.iid === 3
                  })"
                    highlight-current-row
                    stripe
                    style="width: 100%;"
                    @selection-change="handleSelectionChange"
                    fit
                    height="300"
                  >
                    <el-table-column type="selection" width="55px">
                    </el-table-column>
                    <el-table-column sortable prop="id" label="ID" width="80px">
                    </el-table-column>
                    <el-table-column sortable prop="context" label="措施" min-width="150px">
                    </el-table-column>
                    <el-table-column label="操作" width="200px" fixed="right">
                      <template slot-scope="scope">
                        <div>
                          <el-button size="mini" type="primary" @click="handleEdit(scope.row)">编辑</el-button>
                          <el-button size="mini" type="danger" @click="isDel(scope.row.id)">删除
                          </el-button>
                        </div>
                      </template>
                    </el-table-column>
                  </el-table>
                  <el-pagination
                    class="box-pagination"
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="pageNum"
                    :page-sizes="[5,10]"
                    :page-size="pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="getTotal(3)">
                  </el-pagination>
                </div>
              </el-collapse-item>
              <el-collapse-item title="稻纵卷叶螟 Rice leaf roller" name="4">
                <p class="p-title">
                  害虫介绍
                </p>
                <div class="p-box">
                  <p class="p-context">
                    稻纵卷叶螟，别称为刮青虫、白叶虫，苞叶虫等，是中国水稻产区的主要害虫之一，广泛分布于各稻区。除为害水稻外，还可取食大麦、小麦、甘蔗、粟等作物及稗、李氏禾、雀稗、双穗雀稗、马唐、狗尾草、蟋蟀草、茅草、芦苇等杂草。以幼虫为害水稻，缀叶成纵苞，躲藏其中取食上表皮及叶肉，仅留白色下表皮。苗期受害影响水稻正常生长，甚至枯死；分蘖期至拔节期受害，分蘖减少，植株缩短，生育期推迟；孕穗后特别是抽穗到齐穗期剑叶被害，影响开花结实，空壳率提高，千粒重下降。
                  </p>
                </div>
                <p class="p-title">
                  防治措施
                </p>
                <div class="method-box">
                  <el-row>
                    <el-col :span="8">
                      <el-button plain type="primary" icon="el-icon-circle-plus-outline" size="small"
                                 style="margin: 0 5px 5px 10px" @click="handleAdd">
                        新增措施
                      </el-button>
                      <el-button plain type="danger" icon="el-icon-circle-plus-outline" size="small"
                                 style="margin: 0 5px 5px 10px" @click="handleAdd">
                        批量删除
                      </el-button>
                    </el-col>
                    <el-col :span="8" style="border-bottom: 1px solid transparent">

                    </el-col>
                    <el-col :span="8">
                      <el-input
                        suffix-icon="el-icon-search"
                        class="front-search-input"
                        style="width: 200px;border-radius: 20px 0 0 20px !important;"
                        size="small"
                        placeholder="请输入要查找的措施关键字"
                        v-model="$store.state.frontBlogName"></el-input>
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
                  <el-table
                    :data="tableData.filter(e => {
                    return e.iid === 4
                  })"
                    highlight-current-row
                    stripe
                    style="width: 100%;"
                    @selection-change="handleSelectionChange"
                    fit
                    height="300"
                  >
                    <el-table-column type="selection" width="55px">
                    </el-table-column>
                    <el-table-column sortable prop="id" label="ID" width="80px">
                    </el-table-column>
                    <el-table-column sortable prop="context" label="措施" min-width="150px">
                    </el-table-column>
                    <el-table-column label="操作" width="200px" fixed="right">
                      <template slot-scope="scope">
                        <div>
                          <el-button size="mini" type="primary" @click="handleEdit(scope.row)">编辑</el-button>
                          <el-button size="mini" type="danger" @click="isDel(scope.row.id)">删除
                          </el-button>
                        </div>
                      </template>
                    </el-table-column>
                  </el-table>
                  <el-pagination
                    class="box-pagination"
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="pageNum"
                    :page-sizes="[5,10]"
                    :page-size="pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="getTotal(4)">
                  </el-pagination>
                </div>
              </el-collapse-item>
              <el-collapse-item title="绿翅脊萤叶甲 Rice leaf roller" name="5">
                <p class="p-title">
                  害虫介绍
                </p>
                <div class="p-box">
                  <p class="p-context">
                    绿翅脊萤叶甲，为鞘翅目，叶甲科。分布于青海、四川、西藏。幼虫为害麦类及禾本科杂草，成虫不取食禾本科作物。以幼虫蛀入正处在分蘖阶段的麦苗根部茎节内，取食嫩茎的内壁组织，致受害苗变为灰绿色，苗心枯死，基部叶片增厚，常成团或成片受害，边际受害重，造成小麦、大麦缺苗。可转株为害，造成柏心、缺苗、甚至毁种无收，严重影响粮食产量。
                  </p>
                </div>
                <p class="p-title">
                  防治措施
                </p>
                <div class="method-box">
                  <el-row>
                    <el-col :span="8">
                      <el-button plain type="primary" icon="el-icon-circle-plus-outline" size="small"
                                 style="margin: 0 5px 5px 10px" @click="handleAdd">
                        新增措施
                      </el-button>
                      <el-button plain type="danger" icon="el-icon-circle-plus-outline" size="small"
                                 style="margin: 0 5px 5px 10px" @click="handleAdd">
                        批量删除
                      </el-button>
                    </el-col>
                    <el-col :span="8" style="border-bottom: 1px solid transparent">

                    </el-col>
                    <el-col :span="8">
                      <el-input
                        suffix-icon="el-icon-search"
                        class="front-search-input"
                        style="width: 200px;border-radius: 20px 0 0 20px !important;"
                        size="small"
                        placeholder="请输入要查找的措施关键字"
                        v-model="$store.state.frontBlogName"></el-input>
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
                  <el-table
                    :data="tableData.filter(e => {
                    return e.iid === 5
                  })"
                    highlight-current-row
                    stripe
                    style="width: 100%;"
                    @selection-change="handleSelectionChange"
                    fit
                    height="300"
                  >
                    <el-table-column type="selection" width="55px">
                    </el-table-column>
                    <el-table-column sortable prop="id" label="ID" width="80px">
                    </el-table-column>
                    <el-table-column sortable prop="context" label="措施" min-width="150px">
                    </el-table-column>
                    <el-table-column label="操作" width="200px" fixed="right">
                      <template slot-scope="scope">
                        <div>
                          <el-button size="mini" type="primary" @click="handleEdit(scope.row)">编辑</el-button>
                          <el-button size="mini" type="danger" @click="isDel(scope.row.id)">删除
                          </el-button>
                        </div>
                      </template>
                    </el-table-column>
                  </el-table>
                  <el-pagination
                    class="box-pagination"
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="pageNum"
                    :page-sizes="[5,10]"
                    :page-size="pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="getTotal(5)">
                  </el-pagination>
                </div>
              </el-collapse-item>
              <el-collapse-item title="蝼蛄 Rmole cricket" name="6">
                <p class="p-title">
                  害虫介绍
                </p>
                <div class="p-box">
                  <p class="p-context">
                    蝼蛄是节肢动物门，昆虫纲，直翅目，蟋蟀总科，蝼蛄科昆虫的总称。蝼蛄俗名拉拉蛄，地拉蛄，天蝼，土狗等，是药用昆虫。我国大陆上常见的分布较广的蝼蛄有5种，分别是华北蝼蛄、东方蝼蛄、金秀蝼蛄、河南蝼蛄和台湾蝼蛄。一般入药的主要是华北蝼蛄和东方蝼蛄。药用通常为蝼蛄科昆虫蝼蛄的干燥成虫和大个若虫全体。
                  </p>
                </div>
                <p class="p-title">
                  防治措施
                </p>
                <div class="method-box">
                  <el-row>
                    <el-col :span="8">
                      <el-button plain type="primary" icon="el-icon-circle-plus-outline" size="small"
                                 style="margin: 0 5px 5px 10px" @click="handleAdd">
                        新增措施
                      </el-button>
                      <el-button plain type="danger" icon="el-icon-circle-plus-outline" size="small"
                                 style="margin: 0 5px 5px 10px" @click="handleAdd">
                        批量删除
                      </el-button>
                    </el-col>
                    <el-col :span="8" style="border-bottom: 1px solid transparent">

                    </el-col>
                    <el-col :span="8">
                      <el-input
                        suffix-icon="el-icon-search"
                        class="front-search-input"
                        style="width: 200px;border-radius: 20px 0 0 20px !important;"
                        size="small"
                        placeholder="请输入要查找的措施关键字"
                        v-model="$store.state.frontBlogName"></el-input>
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
                  <el-table
                    :data="tableData.filter(e => {
                    return e.iid === 6
                  })"
                    highlight-current-row
                    stripe
                    style="width: 100%;"
                    @selection-change="handleSelectionChange"
                    fit
                    height="300"
                  >
                    <el-table-column type="selection" width="55px">
                    </el-table-column>
                    <el-table-column sortable prop="id" label="ID" width="80px">
                    </el-table-column>
                    <el-table-column sortable prop="context" label="措施" min-width="150px">
                    </el-table-column>
                    <el-table-column label="操作" width="200px" fixed="right">
                      <template slot-scope="scope">
                        <div>
                          <el-button size="mini" type="primary" @click="handleEdit(scope.row)">编辑</el-button>
                          <el-button size="mini" type="danger" @click="isDel(scope.row.id)">删除
                          </el-button>
                        </div>
                      </template>
                    </el-table-column>
                  </el-table>
                  <el-pagination
                    class="box-pagination"
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="pageNum"
                    :page-sizes="[5,10]"
                    :page-size="pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="getTotal(6)">
                  </el-pagination>
                </div>
              </el-collapse-item>
              <el-collapse-item title="褐飞虱 Brown rice planthopper" name="7">
                <p class="p-title">
                  害虫介绍
                </p>
                <div class="p-box">
                  <p class="p-context">
                    褐飞虱是属于半翅目飞虱科的一种动物。 别名：褐稻虱，稻飞虱的一种。 褐飞虱有远距离迁飞习性，是我国和许多亚洲国家当前水稻上的首要害虫。褐飞虱为单食性害虫，只能在水稻和 普通野生稻上取食和繁殖后代。
                  </p>
                </div>
                <p class="p-title">
                  防治措施
                </p>
                <div class="method-box">
                  <el-row>
                    <el-col :span="8">
                      <el-button plain type="primary" icon="el-icon-circle-plus-outline" size="small"
                                 style="margin: 0 5px 5px 10px" @click="handleAdd">
                        新增措施
                      </el-button>
                      <el-button plain type="danger" icon="el-icon-circle-plus-outline" size="small"
                                 style="margin: 0 5px 5px 10px" @click="handleAdd">
                        批量删除
                      </el-button>
                    </el-col>
                    <el-col :span="8" style="border-bottom: 1px solid transparent">

                    </el-col>
                    <el-col :span="8">
                      <el-input
                        suffix-icon="el-icon-search"
                        class="front-search-input"
                        style="width: 200px;border-radius: 20px 0 0 20px !important;"
                        size="small"
                        placeholder="请输入要查找的措施关键字"
                        v-model="$store.state.frontBlogName"></el-input>
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
                  <el-table
                    :data="tableData.filter(e => {
                    return e.iid === 7
                  })"
                    highlight-current-row
                    stripe
                    style="width: 100%;"
                    @selection-change="handleSelectionChange"
                    fit
                    height="300"
                  >
                    <el-table-column type="selection" width="55px">
                    </el-table-column>
                    <el-table-column sortable prop="id" label="ID" width="80px">
                    </el-table-column>
                    <el-table-column sortable prop="context" label="措施" min-width="150px">
                    </el-table-column>
                    <el-table-column label="操作" width="200px" fixed="right">
                      <template slot-scope="scope">
                        <div>
                          <el-button size="mini" type="primary" @click="handleEdit(scope.row)">编辑</el-button>
                          <el-button size="mini" type="danger" @click="isDel(scope.row.id)">删除
                          </el-button>
                        </div>
                      </template>
                    </el-table-column>
                  </el-table>
                  <el-pagination
                    class="box-pagination"
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="pageNum"
                    :page-sizes="[5,10]"
                    :page-size="pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="getTotal(7)">
                  </el-pagination>
                </div>
              </el-collapse-item>
              <el-collapse-item title="亚洲玉米螟 Ostrinia furnacalis" name="8">
                <p class="p-title">
                  害虫介绍
                </p>
                <div class="p-box">
                  <p class="p-context">
                    亚洲玉米螟，属鳞翅目螟蛾科秆野螟属的一种昆虫。是我国玉米等作物的重要害虫 , 从黑龙江到海南各玉米产区均有发生危害 。虽然其成虫具有远距离迁徙的潜力
                    ,主要是近距离扩散。危害玉米植株地上的各个部位，使受害部分丧失功能，降低籽粒产量。在玉米心叶期，初孵幼虫大多爬入心叶内，群聚取食心叶叶肉，留下白色薄膜状表皮，呈花叶状；2、3龄幼虫大多爬入心叶内潜藏为害，心叶展开后，出现整齐的排孔；此后，陆续蛀入茎秆继续为害，蛀孔口常堆有大量粪渣；雄穗被蛀，常易折断，影响授粉；苞叶、花丝被蛀食，会造成缺粒和秕粒；茎秆、穗柄、穗轴被蛀食后，形成隧道，破坏植株内水分、养分的输送，使茎秆倒折率增加，籽粒产量下降。初孵幼虫可吐丝下垂，随风漂移扩散到邻近植株上。
                  </p>
                </div>
                <p class="p-title">
                  防治措施
                </p>
                <div class="method-box">
                  <el-row>
                    <el-col :span="8">
                      <el-button plain type="primary" icon="el-icon-circle-plus-outline" size="small"
                                 style="margin: 0 5px 5px 10px" @click="handleAdd">
                        新增措施
                      </el-button>
                      <el-button plain type="danger" icon="el-icon-circle-plus-outline" size="small"
                                 style="margin: 0 5px 5px 10px" @click="handleAdd">
                        批量删除
                      </el-button>
                    </el-col>
                    <el-col :span="8" style="border-bottom: 1px solid transparent">

                    </el-col>
                    <el-col :span="8">
                      <el-input
                        suffix-icon="el-icon-search"
                        class="front-search-input"
                        style="width: 200px;border-radius: 20px 0 0 20px !important;"
                        size="small"
                        placeholder="请输入要查找的措施关键字"
                        v-model="$store.state.frontBlogName"></el-input>
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
                  <el-table
                    :data="tableData.filter(e => {
                    return e.iid === 8
                  })"
                    highlight-current-row
                    stripe
                    style="width: 100%;"
                    @selection-change="handleSelectionChange"
                    fit
                    height="300"
                  >
                    <el-table-column type="selection" width="55px">
                    </el-table-column>
                    <el-table-column sortable prop="id" label="ID" width="80px">
                    </el-table-column>
                    <el-table-column sortable prop="context" label="措施" min-width="150px">
                    </el-table-column>
                    <el-table-column label="操作" width="200px" fixed="right">
                      <template slot-scope="scope">
                        <div>
                          <el-button size="mini" type="primary" @click="handleEdit(scope.row)">编辑</el-button>
                          <el-button size="mini" type="danger" @click="isDel(scope.row.id)">删除
                          </el-button>
                        </div>
                      </template>
                    </el-table-column>
                  </el-table>
                  <el-pagination
                    class="box-pagination"
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="pageNum"
                    :page-sizes="[5,10]"
                    :page-size="pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="getTotal(8)">
                  </el-pagination>
                </div>
              </el-collapse-item>
              <el-collapse-item title="水稻负泥虫 Rice borer" name="9">
                <p class="p-title">
                  害虫介绍
                </p>
                <div class="p-box">
                  <p class="p-context">
                    水稻负泥虫，为鞘翅目，负泥虫科。主是中国水稻的重要害虫，危害秧苗和稻田的禾苗。成虫、幼虫沿叶脉取食叶肉，在叶尖部分则食穿表皮。大发生年受害严重的禾苗全部变白，或造成禾苗生长黄弱，抽穗不齐，稻谷减产。除危害水稻外，受害作物还有粟、黍、小麦、大麦、玉米、芦苇、糠稷、茭白。
                  </p>
                </div>
                <p class="p-title">
                  防治措施
                </p>
                <div class="method-box">
                  <el-row>
                    <el-col :span="8">
                      <el-button plain type="primary" icon="el-icon-circle-plus-outline" size="small"
                                 style="margin: 0 5px 5px 10px" @click="handleAdd">
                        新增措施
                      </el-button>
                      <el-button plain type="danger" icon="el-icon-circle-plus-outline" size="small"
                                 style="margin: 0 5px 5px 10px" @click="handleAdd">
                        批量删除
                      </el-button>
                    </el-col>
                    <el-col :span="8" style="border-bottom: 1px solid transparent">

                    </el-col>
                    <el-col :span="8">
                      <el-input
                        suffix-icon="el-icon-search"
                        class="front-search-input"
                        style="width: 200px;border-radius: 20px 0 0 20px !important;"
                        size="small"
                        placeholder="请输入要查找的措施关键字"
                        v-model="$store.state.frontBlogName"></el-input>
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
                  <el-table
                    :data="tableData.filter(e => {
                    return e.iid === 9
                  })"
                    highlight-current-row
                    stripe
                    style="width: 100%;"
                    @selection-change="handleSelectionChange"
                    fit
                    height="300"
                  >
                    <el-table-column type="selection" width="55px">
                    </el-table-column>
                    <el-table-column sortable prop="id" label="ID" width="80px">
                    </el-table-column>
                    <el-table-column sortable prop="context" label="措施" min-width="150px">
                    </el-table-column>
                    <el-table-column label="操作" width="200px" fixed="right">
                      <template slot-scope="scope">
                        <div>
                          <el-button size="mini" type="primary" @click="handleEdit(scope.row)">编辑</el-button>
                          <el-button size="mini" type="danger" @click="isDel(scope.row.id)">删除
                          </el-button>
                        </div>
                      </template>
                    </el-table-column>
                  </el-table>
                  <el-pagination
                    class="box-pagination"
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="pageNum"
                    :page-sizes="[5,10]"
                    :page-size="pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="getTotal(9)">
                  </el-pagination>
                </div>
              </el-collapse-item>
              <el-collapse-item title="大螟 Sesamia inferens" name="10">
                <p class="p-title">
                  害虫介绍
                </p>
                <div class="p-box">
                  <p class="p-context">
                    大螟，鳞翅目夜蛾科蛀茎夜蛾属的一种昆虫。成虫雌蛾体长15mm，翅展约30mm，头部、胸部浅黄褐色，腹部浅黄色至灰白色；触角丝状，前翅近长方形，浅灰褐色，中间具小黑点4个排成四角形。雄蛾体长约12mm，翅展27mm，触角栉齿状。卵扁圆形，初白色后变灰黄色，表面具细纵纹和横线，聚生或散生，常排成2—3行。末龄幼虫体长约30mm，粗4头红褐色至暗褐色，共5—7龄。蛹长13—18mm，粗壮，红褐色，腹部具灰白色粉状物，臀棘有3根钩棘。
                  </p>
                </div>
                <p class="p-title">
                  防治措施
                </p>
                <div class="method-box">
                  <el-row>
                    <el-col :span="8">
                      <el-button plain type="primary" icon="el-icon-circle-plus-outline" size="small"
                                 style="margin: 0 5px 5px 10px" @click="handleAdd">
                        新增措施
                      </el-button>
                      <el-button plain type="danger" icon="el-icon-circle-plus-outline" size="small"
                                 style="margin: 0 5px 5px 10px" @click="handleAdd">
                        批量删除
                      </el-button>
                    </el-col>
                    <el-col :span="8" style="border-bottom: 1px solid transparent">

                    </el-col>
                    <el-col :span="8">
                      <el-input
                        suffix-icon="el-icon-search"
                        class="front-search-input"
                        style="width: 200px;border-radius: 20px 0 0 20px !important;"
                        size="small"
                        placeholder="请输入要查找的措施关键字"
                        v-model="$store.state.frontBlogName"></el-input>
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
                  <el-table
                    :data="tableData.filter(e => {
                    return e.iid === 10
                  })"
                    highlight-current-row
                    stripe
                    style="width: 100%;"
                    @selection-change="handleSelectionChange"
                    fit
                    height="300"
                  >
                    <el-table-column type="selection" width="55px">
                    </el-table-column>
                    <el-table-column sortable prop="id" label="ID" width="80px">
                    </el-table-column>
                    <el-table-column sortable prop="context" label="措施" min-width="150px">
                    </el-table-column>
                    <el-table-column label="操作" width="200px" fixed="right">
                      <template slot-scope="scope">
                        <div>
                          <el-button size="mini" type="primary" @click="handleEdit(scope.row)">编辑</el-button>
                          <el-button size="mini" type="danger" @click="isDel(scope.row.id)">删除
                          </el-button>
                        </div>
                      </template>
                    </el-table-column>
                  </el-table>
                  <el-pagination
                    class="box-pagination"
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="pageNum"
                    :page-sizes="[5,10]"
                    :page-size="pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="getTotal(10)">
                  </el-pagination>
                </div>
              </el-collapse-item>
              <el-collapse-item title="稻蓟马 Chloethrips oryzae" name="11">
                <p class="p-title">
                  害虫介绍
                </p>
                <div class="p-box">
                  <p class="p-context">
                    稻蓟马，为缨翅目，蓟马科。北起黑龙江、内蒙古自治区、南至广东、广西和云南，东自台湾及各省，西达四川、贵州均有发生。寄主于 水稻、小麦、玉米、粟、高粱、蚕豆、葱、烟草、甘蔗等。
                    成、若虫以口器锉破叶面，成微细黄白色斑，叶尖两边向内卷折，渐及全叶卷缩枯黄，分蘖初期受害重的稻田，苗不长、根不发、无分蘖，甚至成团枯死。晚稻秧田受害更为严重，常成片枯死，状如火烧。穗期成、若虫趋向穗苞，扬花时，转入颖壳内，为害子房，造成空瘪粒。
                  </p>
                </div>
                <p class="p-title">
                  防治措施
                </p>
                <div class="method-box">
                  <el-row>
                    <el-col :span="8">
                      <el-button plain type="primary" icon="el-icon-circle-plus-outline" size="small"
                                 style="margin: 0 5px 5px 10px" @click="handleAdd">
                        新增措施
                      </el-button>
                      <el-button plain type="danger" icon="el-icon-circle-plus-outline" size="small"
                                 style="margin: 0 5px 5px 10px" @click="handleAdd">
                        批量删除
                      </el-button>
                    </el-col>
                    <el-col :span="8" style="border-bottom: 1px solid transparent">

                    </el-col>
                    <el-col :span="8">
                      <el-input
                        suffix-icon="el-icon-search"
                        class="front-search-input"
                        style="width: 200px;border-radius: 20px 0 0 20px !important;"
                        size="small"
                        placeholder="请输入要查找的措施关键字"
                        v-model="$store.state.frontBlogName"></el-input>
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
                  <el-table
                    :data="tableData.filter(e => {
                    return e.iid === 11
                  })"
                    highlight-current-row
                    stripe
                    style="width: 100%;"
                    @selection-change="handleSelectionChange"
                    fit
                    height="300"
                  >
                    <el-table-column type="selection" width="55px">
                    </el-table-column>
                    <el-table-column sortable prop="id" label="ID" width="80px">
                    </el-table-column>
                    <el-table-column sortable prop="context" label="措施" min-width="150px">
                    </el-table-column>
                    <el-table-column label="操作" width="200px" fixed="right">
                      <template slot-scope="scope">
                        <div>
                          <el-button size="mini" type="primary" @click="handleEdit(scope.row)">编辑</el-button>
                          <el-button size="mini" type="danger" @click="isDel(scope.row.id)">删除
                          </el-button>
                        </div>
                      </template>
                    </el-table-column>
                  </el-table>
                  <el-pagination
                    class="box-pagination"
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="pageNum"
                    :page-sizes="[5,10]"
                    :page-size="pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="getTotal(11)">
                  </el-pagination>
                </div>
              </el-collapse-item>
              <el-collapse-item title="蚊 Mosquito" name="12">
                <p class="p-title">
                  害虫介绍
                </p>
                <div class="p-box">
                  <p class="p-context">
                    蚊属于双翅目、蚊科，又称“蚊子”，是最重要的医学昆虫类群。蚊分布很广，种类很多，迄今为止全世界已记录蚊虫共3亚科（巨蚊亚科、按蚊亚科、库蚊亚科），35属，3600多种和亚种。中国已发现370余种，其中按蚊、库蚊、伊蚊3个属的蚊种超过半数。
                  </p>
                </div>
                <p class="p-title">
                  防治措施
                </p>
                <div class="method-box">
                  <el-row>
                    <el-col :span="8">
                      <el-button plain type="primary" icon="el-icon-circle-plus-outline" size="small"
                                 style="margin: 0 5px 5px 10px" @click="handleAdd">
                        新增措施
                      </el-button>
                      <el-button plain type="danger" icon="el-icon-circle-plus-outline" size="small"
                                 style="margin: 0 5px 5px 10px" @click="handleAdd">
                        批量删除
                      </el-button>
                    </el-col>
                    <el-col :span="8" style="border-bottom: 1px solid transparent">

                    </el-col>
                    <el-col :span="8">
                      <el-input
                        suffix-icon="el-icon-search"
                        class="front-search-input"
                        style="width: 200px;border-radius: 20px 0 0 20px !important;"
                        size="small"
                        placeholder="请输入要查找的措施关键字"
                        v-model="$store.state.frontBlogName"></el-input>
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
                  <el-table
                    :data="tableData.filter(e => {
                    return e.iid === 12
                  })"
                    highlight-current-row
                    stripe
                    style="width: 100%;"
                    @selection-change="handleSelectionChange"
                    fit
                    height="300"
                  >
                    <el-table-column type="selection" width="55px">
                    </el-table-column>
                    <el-table-column sortable prop="id" label="ID" width="80px">
                    </el-table-column>
                    <el-table-column sortable prop="context" label="措施" min-width="150px">
                    </el-table-column>
                    <el-table-column label="操作" width="200px" fixed="right">
                      <template slot-scope="scope">
                        <div>
                          <el-button size="mini" type="primary" @click="handleEdit(scope.row)">编辑</el-button>
                          <el-button size="mini" type="danger" @click="isDel(scope.row.id)">删除
                          </el-button>
                        </div>
                      </template>
                    </el-table-column>
                  </el-table>
                  <el-pagination
                    class="box-pagination"
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="pageNum"
                    :page-sizes="[5,10]"
                    :page-size="pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="getTotal(12)">
                  </el-pagination>
                </div>
              </el-collapse-item>
              <el-collapse-item title="稻蝽 Rice bug" name="13">
                <p class="p-title">
                  害虫介绍
                </p>
                <div class="p-box">
                  <p class="p-context">
                    稻蝽，昆虫纲半翅目。 作物害虫。以成虫和若虫刺吸水稻等 植株的汁液为害。常见种类有蝽科的稻黑蝽、 稻绿蝽、 白边蝽、四剑蝽和缘蝽科的大稻缘蝽。
                  </p>
                </div>
                <p class="p-title">
                  防治措施
                </p>
                <div class="method-box">
                  <el-row>
                    <el-col :span="8">
                      <el-button plain type="primary" icon="el-icon-circle-plus-outline" size="small"
                                 style="margin: 0 5px 5px 10px" @click="handleAdd">
                        新增措施
                      </el-button>
                      <el-button plain type="danger" icon="el-icon-circle-plus-outline" size="small"
                                 style="margin: 0 5px 5px 10px" @click="handleAdd">
                        批量删除
                      </el-button>
                    </el-col>
                    <el-col :span="8" style="border-bottom: 1px solid transparent">

                    </el-col>
                    <el-col :span="8">
                      <el-input
                        suffix-icon="el-icon-search"
                        class="front-search-input"
                        style="width: 200px;border-radius: 20px 0 0 20px !important;"
                        size="small"
                        placeholder="请输入要查找的措施关键字"
                        v-model="$store.state.frontBlogName"></el-input>
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
                  <el-table
                    :data="tableData.filter(e => {
                    return e.iid === 13
                  })"
                    highlight-current-row
                    stripe
                    style="width: 100%;"
                    @selection-change="handleSelectionChange"
                    fit
                    height="300"
                  >
                    <el-table-column type="selection" width="55px">
                    </el-table-column>
                    <el-table-column sortable prop="id" label="ID" width="80px">
                    </el-table-column>
                    <el-table-column sortable prop="context" label="措施" min-width="150px">
                    </el-table-column>
                    <el-table-column label="操作" width="200px" fixed="right">
                      <template slot-scope="scope">
                        <div>
                          <el-button size="mini" type="primary" @click="handleEdit(scope.row)">编辑</el-button>
                          <el-button size="mini" type="danger" @click="isDel(scope.row.id)">删除
                          </el-button>
                        </div>
                      </template>
                    </el-table-column>
                  </el-table>
                  <el-pagination
                    class="box-pagination"
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="pageNum"
                    :page-sizes="[5,10]"
                    :page-size="pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="getTotal(13)">
                  </el-pagination>
                </div>
              </el-collapse-item>
            </el-collapse>
          </div>
        </el-col>
      </el-row>
    </el-card>
    <!--编辑措施信息-->
    <el-dialog :modal-append-to-body="false"
               title="措施信息" class="box-card"
               style="height: 600px !important;padding-top: 100px"
               :visible.sync="dialogFormVisible">
      <el-form
        :inline="false"
        class="demo-form-inline"
        label-width="60px"
        style="display: inline-block;width: 100%;margin-left: 20px"
      >
        <el-form-item label="内容:">
          <el-input style="width: 80%;padding-left: 30px"
                    v-model="context"
                    type="textarea"
                    :autosize="{ minRows: 10, maxRows: 10}"
                    autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <el-row :gutter="10">
        <el-col :span="12" style="display: flex;justify-content: right">
          <el-button type="primary" @click="save">确 定</el-button>
        </el-col>
        <el-col :span="12" style="display: flex;justify-content: left">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
        </el-col>
      </el-row>
    </el-dialog>
    <!--        删除单个用户信息-->
    <el-dialog
      :modal-append-to-body="false"
      title="提示"
      :visible.sync="delDialogVisible"
      width="30%">
      <span>确认删除当前防治措施？</span>
      <span slot="footer" class="dialog-footer">
    <el-button @click="delDialogVisible = false">我再想想</el-button>
    <el-button type="primary" @click="this.doDel">确 定</el-button>
  </span>
    </el-dialog>
    <!--        删除单个用户信息-->
    <el-dialog
      :modal-append-to-body="false"
      title="提示"
      :visible.sync="delAllDialogVisible"
      width="30%">
      <span>确认批量删除当前防治措施？</span>
      <span slot="footer" class="dialog-footer">
    <el-button @click="delAllDialogVisible = false">我再想想</el-button>
    <el-button type="primary" @click="this.doDelAll">确 定</el-button>
  </span>
    </el-dialog>
  </div>
</template>

<script>
import Crontab from '@/components/Crontab'
import axios from 'axios'
import Vue from "vue";
import {methodDelete, methodDeletes, methodInsert, methodList, methodUpdate} from "@/api/file";

Vue.prototype.$axios = axios


export default {
  components: {Crontab},
  name: "Job",
  dicts: ['sys_job_group', 'sys_job_status'],
  data() {
    return {
      refresh: false,
      filePath: '/method/method.txt',
      tableData: [],
      selectId: -1,
      selectIds: [],
      selectIid: -1,
      activeName: '',
      total: 0,
      pageNum: 1,
      pageSize: 10,
      iid: 0,
      context: "",
      methodId: -1,
      dialogFormVisible: false,
      delDialogVisible: false,
      delAllDialogVisible: false,
      insertOrSave: false,
      delId: -1,
      delIds: [],
      searchName: '',
      maxNum: 0,
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 定时任务表格数据
      jobList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 是否显示详细弹出层
      openView: false,
      // 是否显示Cron表达式弹出层
      openCron: false,
      // 传入的表达式
      expression: "",
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        jobName: [
          {required: true, message: "任务名称不能为空", trigger: "blur"}
        ],
        invokeTarget: [
          {required: true, message: "调用目标字符串不能为空", trigger: "blur"}
        ],
        cronExpression: [
          {required: true, message: "cron执行表达式不能为空", trigger: "blur"}
        ]
      },
      imgs: [],
      imgNames: [],
      imgIndex: 0,
      imgOrTest: true,
    }
  },
  created() {
    this.load()
  },
  methods: {
    load() {
      this.tableData = []
      methodList().then(e => {
        this.tableData = e.data
      })
    },
    handleSizeChange(pageSize) {
      this.pageSize = pageSize
      this.load()
    },
    handleCurrentChange(pageNum) {
      this.pageNum = pageNum
      this.load()
    },
    getMethod(iid) {
      let methodData = []
      this.tableData.forEach(t => {
        if (t.iid === iid) {
          methodData.push(t)
        }
      })
      return methodData
    },
    getTotal(iid) {
      let total = 0
      this.tableData.forEach(t => {
        if (t.iid === iid) {
          total++
        }
      })
      return total
    },
    save() {
      if (this.insertOrSave) {
        methodInsert({context: this.context, iid: Number(this.selectIid)}).then(e => {
          this.refresh = !this.refresh
          this.load()
        })
      } else {
        methodUpdate({id: Number(this.selectId), context: this.context, iid: Number(this.selectIid)}).then(e => {
          this.refresh = !this.refresh
          this.load()
        })
      }
      this.dialogFormVisible = false
    },
    changeWin() {
      this.imgOrTest = !this.imgOrTest
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.context = ''
      this.dialogFormVisible = true
      this.insertOrSave = true
    },
    /** 修改按钮操作 */
    handleEdit(row) {
      this.selectId = row.id
      this.selectIid = row.iid
      this.context = row.context
      this.dialogFormVisible = true
      this.insertOrSave = false
    },
    /** 删除操作 */
    isDel(id) {
      this.delId = id
      this.delDialogVisible = true
    },
    isDelAll() {
      if (this.selectIds.length === 0) {
        this.$message.warning("未选择任何防治措施！")
      } else {
        this.delIds = this.selectIds
        this.delAllDialogVisible = true
      }
    },
    doDel() {
      methodDelete(this.delId).then(e => {
        this.load()
      })
      this.delDialogVisible = false
    },
    doDelAll() {
      methodDeletes(this.delIds).then(e => {
        this.load()
      })
      this.delIds = []
      this.delAllDialogVisible = false
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('monitor/job/export', {
        ...this.queryParams
      }, `job_${new Date().getTime()}.xlsx`)
    },
    handleSelectionChange(val) {
      this.selectIds = val.map(m => m.id)
    },
    handleChange(val) {
      console.log(val)
      this.selectIid = val
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
  height: auto;
}

.img-box {
  flex: 1;
  background-color: #fff;
  height: 700px;
  width: auto;
  border-right: 1px solid #2b2b2b;
  padding: 10px;

  ::-webkit-scrollbar {
    display: none;
  }
}

.p-box {
  padding: 10px;
}

.p-title {
  font-weight: bold;
  font-size: 20px;
}

.p-subtitle {
  font-weight: bold;
  font-size: 16px;
}

.p-context {
  font-weight: normal;
  font-size: 14px;
  text-indent: 2em;
}

</style>
