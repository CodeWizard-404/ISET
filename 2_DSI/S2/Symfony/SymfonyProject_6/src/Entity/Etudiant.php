<?php

namespace App\Entity;

use App\Repository\EtudiantRepository;
use Doctrine\ORM\Mapping as ORM;

#[ORM\Entity(repositoryClass: EtudiantRepository::class)]
class Etudiant
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $id = null;

    #[ORM\Column(length: 255)]
    private ?string $nome = null;

    #[ORM\ManyToOne(targetEntity: Institut::class)]
    #[ORM\JoinColumn(name: "institut_id", referencedColumnName: "id")]
    private ?Institut $instit;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getNome(): ?string
    {
        return $this->nome;
    }

    public function setNome(string $nome): static
    {
        $this->nome = $nome;

        return $this;
    }

    /**
     * Set instit
     *
     * @param \App\Entity\Institut|null $instit
     *
     * @return self
     */
    public function setInstit(?\App\Entity\Institut $instit): self
    {
        $this->instit = $instit;

        return $this;
    }

    /**
     * Get instit
     *
     * @return \App\Entity\Institut|null
     */
    public function getInstit(): ?\App\Entity\Institut
    {
        return $this->instit;
    }

}
