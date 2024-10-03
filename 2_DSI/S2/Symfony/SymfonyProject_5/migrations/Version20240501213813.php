<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20240501213813 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE TABLE groupe (id INT AUTO_INCREMENT NOT NULL, PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE utilisateur (id INT AUTO_INCREMENT NOT NULL, PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE Utilisateurs_Groupes (utilisateur_id INT NOT NULL, groupe_id INT NOT NULL, INDEX IDX_8CD4661BFB88E14F (utilisateur_id), INDEX IDX_8CD4661B7A45358C (groupe_id), PRIMARY KEY(utilisateur_id, groupe_id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('ALTER TABLE Utilisateurs_Groupes ADD CONSTRAINT FK_8CD4661BFB88E14F FOREIGN KEY (utilisateur_id) REFERENCES utilisateur (id) ON DELETE CASCADE');
        $this->addSql('ALTER TABLE Utilisateurs_Groupes ADD CONSTRAINT FK_8CD4661B7A45358C FOREIGN KEY (groupe_id) REFERENCES groupe (id) ON DELETE CASCADE');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE Utilisateurs_Groupes DROP FOREIGN KEY FK_8CD4661BFB88E14F');
        $this->addSql('ALTER TABLE Utilisateurs_Groupes DROP FOREIGN KEY FK_8CD4661B7A45358C');
        $this->addSql('DROP TABLE groupe');
        $this->addSql('DROP TABLE utilisateur');
        $this->addSql('DROP TABLE Utilisateurs_Groupes');
    }
}
