package exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import exam.Entity.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
}
