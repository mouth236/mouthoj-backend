package com.mouth.moj.judge.strategy;

import com.mouth.moj.model.dto.question.JudgeCase;
import com.mouth.moj.judge.codesandbox.model.JudgeInfo;
import com.mouth.moj.model.entity.Question;
import com.mouth.moj.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * @ClassName JudgeContext
 * @Description TODO
 * @date 2023/11/20 23:13
 * @Version 1.0
 */
@Data
public class JudgeContext {

    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private List<JudgeCase> judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;
}
