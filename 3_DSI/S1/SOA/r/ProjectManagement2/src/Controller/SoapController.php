<?php
// src/Controller/SoapController.php
namespace App\Controller;

use App\Service\TeamService;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class SoapController extends AbstractController
{
    private $teamService;

    public function __construct(TeamService $teamService)
    {
        $this->teamService = $teamService;
    }

    /**
     * @Route("/soap/affecter-membre", name="soap_affecter_membre", methods={"POST"})
     */
    public function soapServer(): Response
    {
        // Create a new SOAP server
        $server = new \SoapServer(null, [
            'uri' => 'http://localhost:8000/soap/affecter-membre'
        ]);

        // Set the service class which contains the method 'affecterMembre'
        $server->setObject($this->teamService);

        // Start output buffering
        ob_start();

        // Handle the SOAP request
        $server->handle();

        // Create a response object and set content type to XML
        $response = new Response(ob_get_clean());
        $response->headers->set('Content-Type', 'text/xml');

        return $response;
    }
}
