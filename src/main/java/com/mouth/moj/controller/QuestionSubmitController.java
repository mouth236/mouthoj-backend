package com.mouth.moj.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mouth.moj.annotation.AuthCheck;
import com.mouth.moj.common.BaseResponse;
import com.mouth.moj.common.ErrorCode;
import com.mouth.moj.common.ResultUtils;
import com.mouth.moj.constant.UserConstant;
import com.mouth.moj.exception.BusinessException;
import com.mouth.moj.model.dto.question.QuestionQueryRequest;
import com.mouth.moj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.mouth.moj.model.dto.questionsubmit.QuestionSubmitRequest;
import com.mouth.moj.model.entity.Question;
import com.mouth.moj.model.entity.QuestionSubmit;
import com.mouth.moj.model.entity.User;
import com.mouth.moj.model.vo.QuestionSubmitVO;
import com.mouth.moj.service.QuestionSubmitService;
import com.mouth.moj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 题目提交接口
 *
 * @author Mouth
 */
@RestController
@RequestMapping("/question_submit")
@Slf4j
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    /**
     * 提交题目
     * @param questionSubmitRequest
     * @param request
     * @return 提交记录的id
     */
    @PostMapping("/")
    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitRequest questionSubmitRequest,
            HttpServletRequest request) {
        if (questionSubmitRequest == null || questionSubmitRequest.getQuestionId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 登录才能提交题目
        final User loginUser = userService.getLoginUser(request);
        Long questionSubmitId = questionSubmitService.doQuestionSubmit(questionSubmitRequest, loginUser);
        return ResultUtils.success(questionSubmitId);
    }

    /**
     * 分页获取题目列表（仅管理员）
     *
     * @param questionSubmitQueryRequest
     * @param request
     * @return
     */
    @PostMapping("/list/page")
    public BaseResponse<Page<QuestionSubmitVO>> listQuestionSubmitByPage(@RequestBody QuestionSubmitQueryRequest questionSubmitQueryRequest,
                                                                   HttpServletRequest request) {
        long current = questionSubmitQueryRequest.getCurrent();
        long size = questionSubmitQueryRequest.getPageSize();
        //从数据库中查询到原始的题目提交分页信息
        Page<QuestionSubmit> questionSubmitPage = questionSubmitService.page(new Page<>(current, size),
                questionSubmitService.getQueryWrapper(questionSubmitQueryRequest));
        final User loginUser = userService.getLoginUser(request);
        //返回脱敏信息
        return ResultUtils.success(questionSubmitService.getQuestionSubmitVOPage(questionSubmitPage,loginUser));
    }

}
