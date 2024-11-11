package com.perperon.pattern.interpreter;

import com.perperon.pattern.interpreter.impl.Addition;
import com.perperon.pattern.interpreter.impl.PNumber;
import com.perperon.pattern.interpreter.impl.Subtraction;

import java.util.Arrays;

/**
 * @author dupengcheng
 * @date 2024-04-02
 * @apiNote
 */
public class Context {
    public Expression parse(String expression) {
        // 这里我们简化解析过程，假设输入已经是正确的表达式
        // 在实际应用中，这里应该是一个复杂的解析过程，可能会使用到词法分析和语法分析
        String[] parts = expression.split("\\s+");
        System.out.println(Arrays.toString(parts));
        System.out.println(parts.length);
        Expression left = null;
        Expression right = null;

        switch (parts[1]) {
            case "+":
                left = new PNumber(Integer.parseInt(parts[0]));
                right = new PNumber(Integer.parseInt(parts[2]));
                return new Addition(left, right);
            case "-":
                left = new PNumber(Integer.parseInt(parts[0]));
                right = new PNumber(Integer.parseInt(parts[2]));
                return new Subtraction(left, right);
            default:
                return new PNumber(Integer.parseInt(parts[0]));
        }
    }
}
