<?php

namespace Container2MZnk3l;

use Symfony\Component\DependencyInjection\Argument\RewindableGenerator;
use Symfony\Component\DependencyInjection\Exception\RuntimeException;

/**
 * @internal This class has been auto-generated by the Symfony Dependency Injection Component.
 */
class get_ServiceLocator_720mRKVService extends App_KernelDevDebugContainer
{
    /**
     * Gets the private '.service_locator.720mRKV' shared service.
     *
     * @return \Symfony\Component\DependencyInjection\ServiceLocator
     */
    public static function do($container, $lazyLoad = true)
    {
        return $container->privates['.service_locator.720mRKV'] = new \Symfony\Component\DependencyInjection\Argument\ServiceLocator($container->getService, [
            'App\\Controller\\ProduitController::delete' => ['privates', '.service_locator.HkHf8J3', 'get_ServiceLocator_HkHf8J3Service', true],
            'App\\Controller\\ProduitController::edit' => ['privates', '.service_locator.HkHf8J3', 'get_ServiceLocator_HkHf8J3Service', true],
            'App\\Controller\\ProduitController::index' => ['privates', '.service_locator.ONtZwya', 'get_ServiceLocator_ONtZwyaService', true],
            'App\\Controller\\ProduitController::new' => ['privates', '.service_locator.aKM6MDa', 'get_ServiceLocator_AKM6MDaService', true],
            'App\\Controller\\ProduitController::show' => ['privates', '.service_locator.iGUm1r8', 'get_ServiceLocator_IGUm1r8Service', true],
            'App\\Kernel::loadRoutes' => ['privates', '.service_locator.xUrKPVU', 'get_ServiceLocator_XUrKPVUService', true],
            'App\\Kernel::registerContainerConfiguration' => ['privates', '.service_locator.xUrKPVU', 'get_ServiceLocator_XUrKPVUService', true],
            'kernel::loadRoutes' => ['privates', '.service_locator.xUrKPVU', 'get_ServiceLocator_XUrKPVUService', true],
            'kernel::registerContainerConfiguration' => ['privates', '.service_locator.xUrKPVU', 'get_ServiceLocator_XUrKPVUService', true],
            'App\\Controller\\ProduitController:delete' => ['privates', '.service_locator.HkHf8J3', 'get_ServiceLocator_HkHf8J3Service', true],
            'App\\Controller\\ProduitController:edit' => ['privates', '.service_locator.HkHf8J3', 'get_ServiceLocator_HkHf8J3Service', true],
            'App\\Controller\\ProduitController:index' => ['privates', '.service_locator.ONtZwya', 'get_ServiceLocator_ONtZwyaService', true],
            'App\\Controller\\ProduitController:new' => ['privates', '.service_locator.aKM6MDa', 'get_ServiceLocator_AKM6MDaService', true],
            'App\\Controller\\ProduitController:show' => ['privates', '.service_locator.iGUm1r8', 'get_ServiceLocator_IGUm1r8Service', true],
            'kernel:loadRoutes' => ['privates', '.service_locator.xUrKPVU', 'get_ServiceLocator_XUrKPVUService', true],
            'kernel:registerContainerConfiguration' => ['privates', '.service_locator.xUrKPVU', 'get_ServiceLocator_XUrKPVUService', true],
        ], [
            'App\\Controller\\ProduitController::delete' => '?',
            'App\\Controller\\ProduitController::edit' => '?',
            'App\\Controller\\ProduitController::index' => '?',
            'App\\Controller\\ProduitController::new' => '?',
            'App\\Controller\\ProduitController::show' => '?',
            'App\\Kernel::loadRoutes' => '?',
            'App\\Kernel::registerContainerConfiguration' => '?',
            'kernel::loadRoutes' => '?',
            'kernel::registerContainerConfiguration' => '?',
            'App\\Controller\\ProduitController:delete' => '?',
            'App\\Controller\\ProduitController:edit' => '?',
            'App\\Controller\\ProduitController:index' => '?',
            'App\\Controller\\ProduitController:new' => '?',
            'App\\Controller\\ProduitController:show' => '?',
            'kernel:loadRoutes' => '?',
            'kernel:registerContainerConfiguration' => '?',
        ]);
    }
}
