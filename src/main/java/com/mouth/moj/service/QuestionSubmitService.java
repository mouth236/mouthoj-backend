package com.mouth.moj.service;

import com.mouth.moj.model.dto.questionsubmit.QuestionSubmitRequest;
import com.mouth.moj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mouth.moj.model.entity.User;

/**
* @author Lenovo
* @description 针对表【question_submit(题目提交表)】的数据库操作Service
* @createDate 2023-11-17 22:04:44
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {
    /**
     * 题目提交
     *
     * @param questionSubmitRequest
     * @param loginUser
     * @return
     */
    Long doQuestionSubmit(QuestionSubmitRequest questionSubmitRequest, User loginUser);

}
