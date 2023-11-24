package com.mouth.moj.judge.codesandbox;

import com.github.mustachejava.Code;
import com.mouth.moj.judge.codesandbox.impl.ExampleCodeSandbox;
import com.mouth.moj.judge.codesandbox.model.ExecuteCodeReponse;
import com.mouth.moj.judge.codesandbox.model.ExecuteCodeRequest;
import com.mouth.moj.model.enums.QuestionSubmitLanguageEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ClassName CodeSandboxTest
 * @Description TODO
 * @date 2023/11/20 21:32
 * @Version 1.0
 */
@SpringBootTest
class CodeSandboxTest {

    @Value("${codesandbox.type:example}")
    private String type;
    @Test
    void exexuteCode() {
        CodeSandbox codeSandbox = new ExampleCodeSandbox();
        String code = "int main()";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2", "3,4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .inputList(inputList)
                .language(language)
                .build();
        ExecuteCodeReponse executeCodeReponse = codeSandbox.exexuteCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeReponse);
    }
    @Test
    void exexuteCodeByValue() {
        CodeSandbox codeSandbox =CodeSandboxFactory.newInstance(type);
        String code = "int main()";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2", "3,4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .inputList(inputList)
                .language(language)
                .build();
        ExecuteCodeReponse executeCodeReponse = codeSandbox.exexuteCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeReponse);
    }
    @Test
    void exexuteCodeByProxy() {
        CodeSandbox codeSandbox =CodeSandboxFactory.newInstance(type);
        codeSandbox = new CodeSandboxProxy(codeSandbox);
        String code = "public class Main {\n" +
                "\n" +
                "    public static void main(String[] args) {\n" +
                "        int a =Integer.parseInt(args[0]);\n" +
                "        int b =Integer.parseInt(args[1]);\n" +
                "        System.out.println(\"结果：\"+(a+b));\n" +
                "    }\n" +
                "}";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .inputList(inputList)
                .language(language)
                .build();
        ExecuteCodeReponse executeCodeReponse = codeSandbox.exexuteCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeReponse);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String type = scanner.next();
            CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
            String code = "int main()";
            String language = QuestionSubmitLanguageEnum.JAVA.getValue();
            List<String> inputList = Arrays.asList("1 2", "3,4");
            ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                    .code(code)
                    .inputList(inputList)
                    .language(language)
                    .build();
            ExecuteCodeReponse executeCodeReponse = codeSandbox.exexuteCode(executeCodeRequest);
        }
    }
}
