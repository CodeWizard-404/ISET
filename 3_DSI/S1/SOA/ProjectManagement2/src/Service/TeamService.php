<?php
// src/Service/TeamService.php
namespace App\Service;

use App\Entity\Member;
use App\Entity\Team;
use Doctrine\ORM\EntityManagerInterface;

class TeamService
{
    private $entityManager;

    public function __construct(EntityManagerInterface $entityManager)
    {
        $this->entityManager = $entityManager;
    }

    public function affecterMembre(string $memberName, string $teamName): string
    {
        // Find the team by name
        $team = $this->entityManager->getRepository(Team::class)->findOneBy(['name' => $teamName]);
    
        if (!$team) {
            return "L'équipe $teamName n'existe pas.";
        }
    
        // Create a new member
        $member = new Member();
        $member->setName($memberName);
        $member->setEmail("{$memberName}@example.com"); // Replace with real email logic
    
        // Set the team for the member
        $member->addTeam($team); // Ensure both sides of the relationship are updated
    
        // Persist the member to the database
        $this->entityManager->persist($member);
        $this->entityManager->flush();
    
        return "Le membre $memberName a été affecté à l'équipe $teamName.";
    }
    
    
}

