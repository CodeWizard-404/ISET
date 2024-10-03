package exam.Controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import exam.Entity.Operation;
import exam.Services.CalculatorService;

import java.util.List;

@RestController
@RequestMapping("/calc")
public class CalculController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/operations")
    public List<Operation> getAllOperations() {
        return calculatorService.getAllOperations();
    }

    @PostMapping("/add")
    public Operation add(@RequestParam int operand1, @RequestParam int operand2) {
        return calculatorService.addOperation(operand1, operand2);
    }

    @PostMapping("/sub")
    public Operation subtract(@RequestParam int operand1, @RequestParam int operand2) {
        return calculatorService.subtractOperation(operand1, operand2);
    }

    @PostMapping("/mul")
    public Operation multiply(@RequestParam int operand1, @RequestParam int operand2) {
        return calculatorService.multiplyOperation(operand1, operand2);
    }

    @PostMapping("/div")
    public Operation divide(@RequestParam int operand1, @RequestParam int operand2) {
        return calculatorService.divideOperation(operand1, operand2);
    }
}

