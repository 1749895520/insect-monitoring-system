package com.ruoyi.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("detect_to_insect")
@ApiModel(value = "detect_to_insect对象", description = "")
public class DetectToInsect {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("预测id")
    private Integer did;

    @ApiModelProperty("害虫id")
    private Integer iid;

    @ApiModelProperty("害虫数量")
    private Integer number;
}
