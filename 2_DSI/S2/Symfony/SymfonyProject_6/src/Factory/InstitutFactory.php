<?php

namespace App\Factory;

use App\Entity\Institut;
use App\Repository\InstitutRepository;
use Zenstruck\Foundry\ModelFactory;
use Zenstruck\Foundry\Proxy;
use Zenstruck\Foundry\RepositoryProxy;

/**
 * @extends ModelFactory<Institut>
 *
 * @method        Institut|Proxy create(array|callable $attributes = [])
 * @method static Institut|Proxy createOne(array $attributes = [])
 * @method static Institut|Proxy find(object|array|mixed $criteria)
 * @method static Institut|Proxy findOrCreate(array $attributes)
 * @method static Institut|Proxy first(string $sortedField = 'id')
 * @method static Institut|Proxy last(string $sortedField = 'id')
 * @method static Institut|Proxy random(array $attributes = [])
 * @method static Institut|Proxy randomOrCreate(array $attributes = [])
 * @method static InstitutRepository|RepositoryProxy repository()
 * @method static Institut[]|Proxy[] all()
 * @method static Institut[]|Proxy[] createMany(int $number, array|callable $attributes = [])
 * @method static Institut[]|Proxy[] createSequence(iterable|callable $sequence)
 * @method static Institut[]|Proxy[] findBy(array $attributes)
 * @method static Institut[]|Proxy[] randomRange(int $min, int $max, array $attributes = [])
 * @method static Institut[]|Proxy[] randomSet(int $number, array $attributes = [])
 */
final class InstitutFactory extends ModelFactory
{
    /**
     * @see https://symfony.com/bundles/ZenstruckFoundryBundle/current/index.html#factories-as-services
     *
     * @todo inject services if required
     */
    public function __construct()
    {
        parent::__construct();
    }

    /**
     * @see https://symfony.com/bundles/ZenstruckFoundryBundle/current/index.html#model-factories
     *
     * @todo add your default values here
     */
    protected function getDefaults(): array
    {
        return [
            'nomi' => self::faker()->text(255),
        ];
    }

    /**
     * @see https://symfony.com/bundles/ZenstruckFoundryBundle/current/index.html#initialization
     */
    protected function initialize(): self
    {
        return $this
            // ->afterInstantiate(function(Institut $institut): void {})
        ;
    }

    protected static function getClass(): string
    {
        return Institut::class;
    }
}
