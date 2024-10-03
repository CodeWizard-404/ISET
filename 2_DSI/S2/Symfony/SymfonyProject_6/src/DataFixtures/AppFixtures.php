<?php

namespace App\DataFixtures;

use Doctrine\Bundle\FixturesBundle\Fixture;
use Doctrine\Persistence\ObjectManager;

use App\Factory\EtudiantFactory;
Use App\Factory\InstitutFactory;

class AppFixtures extends Fixture
{
    public function load(ObjectManager $manager): void
    {
        EtudiantFactory::createMany(10);
        InstitutFactory::createMany(10);
    }
}
