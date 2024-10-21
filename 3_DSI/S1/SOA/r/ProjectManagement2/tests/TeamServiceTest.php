<?php
namespace App\Tests\Service;

use App\Service\TeamService;
use Symfony\Bundle\FrameworkBundle\Test\KernelTestCase;

class TeamServiceTest extends KernelTestCase
{
    private $teamService;

    protected function setUp(): void
    {
        self::bootKernel();
        $this->teamService = static::getContainer()->get(TeamService::class);
    }

    public function testAffecterMembre()
    {
        $result = $this->teamService->affecterMembre('Jane Doe', 'Manager', 2);
        $this->assertEquals("Le membre Jane Doe a été affecté à l'équipe 2.", $result);
    }
}
