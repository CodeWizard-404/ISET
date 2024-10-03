<?php

namespace App\Controller;

use App\Entity\Institut;
use App\Form\InstitutType;
use App\Repository\InstitutRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

#[Route('/institut')]
class InstitutController extends AbstractController
{
    #[Route('/', name: 'app_institut_index', methods: ['GET'])]
    public function index(InstitutRepository $institutRepository): Response
    {
        return $this->render('institut/index.html.twig', [
            'instituts' => $institutRepository->findAll(),
        ]);
    }

    #[Route('/new', name: 'app_institut_new', methods: ['GET', 'POST'])]
    public function new(Request $request, EntityManagerInterface $entityManager): Response
    {
        $institut = new Institut();
        $form = $this->createForm(InstitutType::class, $institut);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->persist($institut);
            $entityManager->flush();

            return $this->redirectToRoute('app_institut_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->renderForm('institut/new.html.twig', [
            'institut' => $institut,
            'form' => $form,
        ]);
    }

    #[Route('/{id}', name: 'app_institut_show', methods: ['GET'])]
    public function show(Institut $institut): Response
    {
        return $this->render('institut/show.html.twig', [
            'institut' => $institut,
        ]);
    }

    #[Route('/{id}/edit', name: 'app_institut_edit', methods: ['GET', 'POST'])]
    public function edit(Request $request, Institut $institut, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(InstitutType::class, $institut);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            return $this->redirectToRoute('app_institut_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->renderForm('institut/edit.html.twig', [
            'institut' => $institut,
            'form' => $form,
        ]);
    }

    #[Route('/{id}', name: 'app_institut_delete', methods: ['POST'])]
    public function delete(Request $request, Institut $institut, EntityManagerInterface $entityManager): Response
    {
        if ($this->isCsrfTokenValid('delete'.$institut->getId(), $request->request->get('_token'))) {
            $entityManager->remove($institut);
            $entityManager->flush();
        }

        return $this->redirectToRoute('app_institut_index', [], Response::HTTP_SEE_OTHER);
    }
}
