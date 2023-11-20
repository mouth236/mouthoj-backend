package com.mouth.moj.model.enums;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 判题信息枚举
 *
 * @author Mouth
 */
public enum JudgeInfoMessageEnum {

    ACCEPTED("成功", "accepted"),
    WRONG_ANSWER("答案错误", "wrong answer"),
    COMPILE_ERROR("compile error", "编译出错"),
    MEMORY_LIMIT_EXCEEDED("memory limit exceeded", "内存溢出"),
    TIME_LIMIT_EXCEEDED("time limit exceeded", "超时"),
    PRESENTATION_ERROR("presentation error", "展示错误"),
    WATING("wating", "等待中"),
    OUTPUT_LIMIT_EXCEEDED("output limit exceeded", "输出溢出"),
    DANGEROUS_OPERATION("dangerous operation", "危险操作"),
    RUNTIME_ERROR("runtime error", "运行错误"),
    SYSTEM_ERROR("system_error", "系统错误");

    private final String text;

    private final String value;

    JudgeInfoMessageEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    /**
     * 获取值列表
     *
     * @return
     */
    public static List<String> getValues() {
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());
    }

    /**
     * 根据 value 获取枚举
     *
     * @param value
     * @return
     */
    public static JudgeInfoMessageEnum getEnumByValue(String value) {
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        for (JudgeInfoMessageEnum anEnum : JudgeInfoMessageEnum.values()) {
            if (anEnum.value.equals(value)) {
                return anEnum;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
