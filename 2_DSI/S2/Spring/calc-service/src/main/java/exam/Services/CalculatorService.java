package exam.Services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exam.Entity.Operation;
import exam.Repository.OperationRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CalculatorService {

    @Autowired
    private OperationRepository operationRepository;

    public List<Operation> getAllOperations() {
        return operationRepository.findAll();
    }

    public Operation addOperation(int operand1, int operand2) {
        return saveOperation("ADD", operand1, operand2, operand1 + operand2);
    }

    public Operation subtractOperation(int operand1, int operand2) {
        return saveOperation("SUB", operand1, operand2, operand1 - operand2);
    }

    public Operation multiplyOperation(int operand1, int operand2) {
        return saveOperation("MUL", operand1, operand2, operand1 * operand2);
    }

    public Operation divideOperation(int operand1, int operand2) {
        if (operand2 == 0) {
            throw new IllegalArgumentException("Division by zero");
        }
        return saveOperation("DIV", operand1, operand2, operand1 / operand2);
    }

    private Operation saveOperation(String type, int operand1, int operand2, int result) {
        Operation operation = new Operation();
        operation.setType(type);
        operation.setOperand1(operand1);
        operation.setOperand2(operand2);
        operation.setResult(result);
        operation.setDate(LocalDateTime.now());
        return operationRepository.save(operation);
    }
}
