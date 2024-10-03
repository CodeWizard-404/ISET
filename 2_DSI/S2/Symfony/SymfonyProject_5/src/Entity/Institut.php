<?php

namespace App\Entity;

use App\Repository\InstitutRepository;
use Doctrine\ORM\Mapping as ORM;

#[ORM\Entity(repositoryClass: InstitutRepository::class)]
class Institut
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $id = null;

    #[ORM\Column(length: 255)]
    private ?string $nomi = null;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getNomi(): ?string
    {
        return $this->nomi;
    }

    public function setNomi(string $nomi): static
    {
        $this->nomi = $nomi;

        return $this;
    }
}
