package exam.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String type;
    private int operand1;
    private int operand2;
    private int result;
    private LocalDateTime date;
    
	public Operation(Long id, String type, int operand1, int operand2, int result, LocalDateTime date) {
		super();
		this.id = id;
		this.type = type;
		this.operand1 = operand1;
		this.operand2 = operand2;
		this.result = result;
		this.date = date;
	}
	
	public Operation() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getOperand1() {
		return operand1;
	}

	public void setOperand1(int operand1) {
		this.operand1 = operand1;
	}

	public int getOperand2() {
		return operand2;
	}

	public void setOperand2(int operand2) {
		this.operand2 = operand2;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Operation [id=" + id + ", type=" + type + ", operand1=" + operand1 + ", operand2=" + operand2
				+ ", result=" + result + ", date=" + date + "]";
	}
	
	
	
	
    
    
    
}
