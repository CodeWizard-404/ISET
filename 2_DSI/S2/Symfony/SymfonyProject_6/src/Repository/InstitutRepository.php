<?php

namespace App\Repository;

use App\Entity\Institut;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @extends ServiceEntityRepository<Institut>
 *
 * @method Institut|null find($id, $lockMode = null, $lockVersion = null)
 * @method Institut|null findOneBy(array $criteria, array $orderBy = null)
 * @method Institut[]    findAll()
 * @method Institut[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class InstitutRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Institut::class);
    }

//    /**
//     * @return Institut[] Returns an array of Institut objects
//     */
//    public function findByExampleField($value): array
//    {
//        return $this->createQueryBuilder('i')
//            ->andWhere('i.exampleField = :val')
//            ->setParameter('val', $value)
//            ->orderBy('i.id', 'ASC')
//            ->setMaxResults(10)
//            ->getQuery()
//            ->getResult()
//        ;
//    }

//    public function findOneBySomeField($value): ?Institut
//    {
//        return $this->createQueryBuilder('i')
//            ->andWhere('i.exampleField = :val')
//            ->setParameter('val', $value)
//            ->getQuery()
//            ->getOneOrNullResult()
//        ;
//    }
}
