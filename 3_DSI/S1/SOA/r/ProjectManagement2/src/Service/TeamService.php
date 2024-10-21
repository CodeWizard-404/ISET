<?php
// src/Service/TeamService.php
namespace App\Service;

use App\Repository\TeamRepository;
use App\Repository\MemberRepository; // Assuming you have a Member repository
use Doctrine\ORM\EntityManagerInterface;

class TeamService
{
    private $teamRepository;
    private $memberRepository;
    private $entityManager;

    public function __construct(TeamRepository $teamRepository, MemberRepository $memberRepository, EntityManagerInterface $entityManager)
    {
        $this->teamRepository = $teamRepository;
        $this->memberRepository = $memberRepository;
        $this->entityManager = $entityManager;
    }

    /**
     * Assign a member to a team.
     *
     * @param int $memberId The ID of the member.
     * @param int $teamId The ID of the team.
     * @return string Confirmation message.
     * @throws \Exception if the team or member is not found.
     */
    public function affecterMembre(int $memberId, int $teamId): string
    {
        // Find the team
        $team = $this->teamRepository->find($teamId);
        if (!$team) {
            throw new \Exception("Team not found with ID $teamId.");
        }

        // Find the member
        $member = $this->memberRepository->find($memberId);
        if (!$member) {
            throw new \Exception("Member not found with ID $memberId.");
        }

        // Assuming the Team entity has a method to add a member
        $team->addMember($member);

        // Save changes to the database
        $this->entityManager->persist($team);
        $this->entityManager->flush();

        return "Member $memberId has been successfully assigned to team $teamId.";
    }
}
