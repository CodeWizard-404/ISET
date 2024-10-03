<?php

namespace App\Entity;

use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use App\Repository\UtilisateurRepository;
use Doctrine\ORM\Mapping as ORM;

#[ORM\Entity(repositoryClass: UtilisateurRepository::class)]
class Utilisateur
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $id = null;



    /**
     * Many Utilisateus have Many Groupes.
     * @var Collection<int, Groupe>
     */

    #[ORM\ManyToMany(targetEntity: Groupe::class, inversedBy: 'Utilisateurs')]
    #[ORM\JoinTable(name: 'Utilisateurs_Groupes')]
    private Collection $Groupes;

    public function __construct()
    {
        $this->Groupes = new ArrayCollection();
    }

    public function getId(): ?int
    {
        return $this->id;
    }
}
