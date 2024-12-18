package com.test.test.CalculatorController;

import com.test.test.Service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {

        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String showGreetings() {
        return "<h1>Добро пожаловать в калькулятор</h1>";
    }

    @GetMapping("/plus")
    public String sum(@RequestParam Integer num1, @RequestParam Integer num2) {
        Integer result = calculatorService.sum(num1, num2);
        return generateMassage(num1, num2, '+', result);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam Integer num1, @RequestParam Integer num2) {
        Integer result = calculatorService.minus(num1, num2);
        return generateMassage(num1, num2, '-', result);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam Integer num1, @RequestParam Integer num2) {
        Integer result = calculatorService.multiply(num1, num2);
        return generateMassage(num1, num2, '*', result);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam Integer num1, @RequestParam Integer num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("mistake");
        }
        Integer result = calculatorService.divide(num1, num2);
        return generateMassage(num1, num2, '/', result);
    }

    private String generateMassage(Integer num1, Integer num2, char action, int result) {
        return String.format("<h1>%d %c %d = %d</h1>", num1, action, num2, result);
    }
}