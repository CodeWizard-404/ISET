<?php
namespace App\Controller;

use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use App\Service\TeamService;
use Symfony\Component\DependencyInjection\Attribute\AsController;

<<<<<<< HEAD
#[AsController] // This line ensures the controller is public in Symfony 6 or higher
=======
#[AsController]
>>>>>>> 5f9aad9cacfa64b2305e1a079717834bf1d29601
class SoapController
{
    private TeamService $teamService;

    public function __construct(TeamService $teamService)
    {
        $this->teamService = $teamService;
    }

    #[Route("/soap/affecter-membre", name: "soap_affecter_membre", methods: ["POST"])]
    public function soapServer(): Response
    {
        $server = new \SoapServer(null, [
            'uri' => 'http://localhost:8000/soap/affecter-membre'
        ]);

        $server->setObject($this->teamService);
        ob_start();
        $server->handle();
        $responseContent = ob_get_clean();

        return new Response($responseContent, 200, ['Content-Type' => 'text/xml']);
    }
}
