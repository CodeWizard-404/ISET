<?php

namespace App\Controller\Admin;

use App\Entity\Medecin;
use EasyCorp\Bundle\EasyAdminBundle\Controller\AbstractCrudController;
use EasyCorp\Bundle\EasyAdminBundle\Field\IdField;
use EasyCorp\Bundle\EasyAdminBundle\Field\TextEditorField;
use EasyCorp\Bundle\EasyAdminBundle\Field\TextField;
use EasyCorp\Bundle\EasyAdminBundle\Config\Crud;
use EasyCorp\Bundle\EasyAdminBundle\Config\Filters;
use EasyCorp\Bundle\EasyAdminBundle\Field\AssociationField;

class MedecinCrudController extends AbstractCrudController
{
    public static function getEntityFqcn(): string
    {
        return Medecin::class;
    }

    
    public function configureFields(string $pageName): iterable
    {
        return [
            //IdField::new('id'),
            TextField::new('nom_med'),
            TextField::new('nom'),
            TextField::new('adresse'),
            TextField::new('email'),
            AssociationField::new('service'),
        ];
    }

    public function configureCrud(Crud $crud): Crud
    {
        return $crud
            ->setEntityLabelInSingular('Doctor')
            ->setEntityLabelInPlural('Doctors')
            ->setPageTitle(Crud::PAGE_INDEX, 'List of Doctors')
            ->setPageTitle(Crud::PAGE_EDIT, 'Edit Doctor')
            ->setPageTitle(Crud::PAGE_NEW, 'Create Doctor')
            ->setPageTitle(Crud::PAGE_DETAIL, 'Doctor Details');
    }
    
}
