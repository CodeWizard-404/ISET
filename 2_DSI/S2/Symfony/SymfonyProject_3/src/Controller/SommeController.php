<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class SommeController extends AbstractController
{
    #[Route('/somme', name: 'app_somme')]
    public function index(): Response
    {
        return $this->render('somme/index.html.twig', [
            'controller_name' => 'SommeController',
        ]);
    }
    
    /**
     * @Route("/somme/{a}/{b}", name="somme")
     */
    public function somme($a,$b): Response
    { $s = $a + $b;
        return $this->render('somme/somme.html.twig', [
            'op1' => $a,
            'op2' => $b,
            'somme' => $s
        ]);
    }
}
