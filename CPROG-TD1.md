# TD 1
## Remarques préliminaires
* Pour l'ensemble des TDs, vous créerez un compte individuel sur [github](https://github.com/) si vous n'en possédez pas déjà un.
Vous nommerez ce compte de la façon suivante: `uvsq<MonNuméroÉtudiant>`.
Par exemple, pour un étudiant de numéro *21601234*, le compte sera `uvsq21601234`.
* Les commandes `git` sont à taper en ligne de commande dans un *shell*.
* Vous pouvez utiliser l'IDE de votre choix.
Sur le cartable numérique, [Eclipse](www.eclipse.org), [IntelliJ IDEA](http://www.jetbrains.com/idea/) et [Visual Studio Code](https://code.visualstudio.com/) sont installés.
* Vous répondrez aux questions directement dans ce fichier en complétant les emplacements correspondants.
Ajoutez ensuite ce fichier au dépôt `git`.

## Partie I (à faire durant le TD) : découverte de `git`
Dans cet exercice, vous créerez une classe `Fraction` représentant un nombre rationnel et une classe `Main` qui testera les méthodes de la classe `Fraction` **avec des assertions**.
À chaque étape, consultez le statut des fichiers du projet ainsi que l'historique.

1. Sur la forge, créez le dépôt (_repository_) `SimpleFraction`;
En terme de *commits*, quelle différence constatez-vous entre cocher une (ou plusieurs) des cases *Initialize this repository with* et n'en cocher aucune ?
    > En cochant les cases on ajoutes des fichiers au dépôt dès sont initialisation donc son premier commit contient l'ajout des fichiers README.md, .gitignore et LICENCE créés.

    *Pour la suite, ne cochez aucune de ces cases*.
1. Localement, configurez `git` avec votre nom (`user.name`) et votre email (`user.email`);
    ```bash
    git config --global user.name "uvsq21800138"
    git config --global user.email "coralie.zens@ens.uvsq.fr"
    ```
1. Initialisez le dépôt `git` local pour le projet;
    ```bash
    git init SimpleFraction2
   # OU #
    git clone https://github.com/uvsq21800138/SimpleFraction2.git 
    ```
1. Créez la classe `Fraction` (vide pour le moment) et la classe `Main` (avec un simple affichage) dans le projet;
Vérifiez que le projet compile et s'exécute dans l'IDE;
Validez les changements;
    ```bash
    git add src/Main.java
    git add src/Fraction.java
    git commit -m "Ajout des classes Java"
    ```
1. Ajoutez un constructeur et la méthode `toString` à la classe `Fraction` et modifiez la classe `Main` en conséquence;
Validez les changements;
    ```Java
   public class Main {
       public static void main(String[] argv) {
           System.out.println("Fraction :");
           Fraction f1 = new Fraction(3,4);
           assert f1.toString().equals("{3/4}") : "Erreur dans Fraction.toString";
           System.out.println(f1.toString());
       }
   }
    ```
1. Publiez vos modifications sur le dépôt distant;
Vous utiliserez le protocole `https` pour cela;
Vérifiez avec le navigateur;
    ```bash
    git commit -a -m "Modification toString"
    git push -u https://github.com/uvsq21800138/SimpleFraction2.git master
    ```
1. Sur la forge, ajoutez un fichier de documentation `README.md`.
Quelle syntaxe est utilisée pour ce fichier ?
    > La syntaxe utilisée dans les fichiers .md est markdown.
1. Récupérez localement les modifications effectuées sur la forge.
    ```bash
    git pull https://github.com/uvsq21800138/SimpleFraction2.git master
    ```
1. Ajoutez les répertoires et fichiers issus de la compilation aux fichiers ignorés par `git` (fichier `.gitignore`);
    ```bash
    # Fichier de compilation
    out/
    ```
1. Retirez les fichiers de configuration de l'IDE du projet;
    ```bash
    # Si il avait été ajouté pour les retirer
    git reset --cached .idea/*
    git reset --cached SimpleFraction2.iml
    ```
    Ajoutez-les aux fichiers ignorés par `git`.
    ```bash
    # Fichier de configuration IDEA
    .idea/
    *.iml
    ```
1. Configurez l'accès par clé publique/clé privée à la forge (cf. [Connecting to GitHub with SSH](https://docs.github.com/en/authentication/connecting-to-github-with-ssh)).
    > La procedure clé publique/clé privée créé 2 clés, l'une à conserver sur le poste de travail et la seconde à fournir à la forge pour qu'elle reconnaisse le poste lors de la procedure d'authentification.
    ```
    ssh-keygen -t ed25519 -C "coralie.zens@ens.uvsq.fr"
    eval "$(ssh-agent -s)"
    ssh-add ~/.ssh/id_ed25519
    ```
   
## Partie II (à faire à la maison) : révisions et perfectionnement *shell* et *IDE*
### Maîtriser le *shell* de commandes
L'objectif de cet exercice est de vous faire réviser/découvrir les commandes de base du *shell* de votre machine.
Vous pouvez répondre en utilisant le shell de votre choix (*bash*, *Powershell*, …).
Pour répondre à ces questions, vous devez effectuer les recherches documentaires adéquates (livre, web, …).

1. Quel OS et quel shell de commande utilisez-vous ?
    > Je suis sous Windows 10 et j'utilise Git bash.
1. Quelle commande permet d'obtenir de l'aide ?
Donnez un exemple.
    ```bash
    help
    ```
1. Donnez la ou les commandes shell permettant de
    1. afficher les fichiers d'un répertoire triés par taille (taille affichée lisiblement)
        ```bash
        ls -Ssh1
        ```
    1. compter le nombre de ligne d'un fichier
        ```bash
        wc -l [fichier]
        ```
    1. afficher les lignes du fichier `Main.java` contenant la chaîne `uneVariable`
        ```bash
        grep -F "UneVariable" Main.java
        ```
    1. afficher récursivement les fichiers `.java` contenant la chaîne `uneVariable`
        ```bash
        grep "UneVariable" -rl --include="*.java"
        ```
    1. trouver les fichiers (pas les répertoires) nommés `README.md` dans une arborescence de répertoires
        ```bash
        find -type f -name README.md
        ```
    1. afficher les différences entre deux fichiers textes
        ```bash
        diff fichier1.txt fichier2.txt
        ```
1. Expliquez en une ou deux phrases le rôle de ces commandes et dans quel contexte elles peuvent être utiles pour un développeur.
    * `ssh`
        > Permet de se connecter à une machine distante pour sécuriser et authentifier la connexion selon une procédure ssh.
    * `screen`/`tmux`
        > Permet d'ouvrir plusieurs terminals simultanément dans une seule fenêtre.
    * `curl`/[HTTPie](https://httpie.org/)
        > Permet de faire des requêtes sur un serveur selon divers protocoles de transfert d'information (http/https, ftp...).
    * [jq](https://stedolan.github.io/jq/)
        > Cette commande permet de modifier (découper, filtrer, mapper, transformer) des données de fichier .json tout comme sed et grep le font sur des textes.

### Découverte de votre *IDE*
Dans cet exercice, vous expliquerez en quelques phrases comment vous réalisez les actions ci-dessous dans votre IDE.
Vous pouvez choisir l'IDE/éditeur de texte de votre choix.
Pour réaliser cette exercice, vous devez bien évidemment vous reporter à la documentations de l'IDE ([IntelliJ IDEA](https://www.jetbrains.com/help/idea/discover-intellij-idea.html#developer-tools), [Visual Studio Code](https://code.visualstudio.com/docs), [Eclipse](https://help.eclipse.org/2020-09/index.jsp), …).

1. Quels IDE ou éditeurs de texte utilisez-vous pour le développement Java ?
    > J'utilise IntelliJ IDEA.

    Pour la suite, ne considérez que l'un de vos choix.
1. Comment vérifier/définir que l'encodage utilisé est *UTF-8* ?
    > Le paramètre est affiché en bas à droite de la fenêtre et se trouve dans File>Settings>Editor>File Encoding.
1. Comment choisir le JDK à utiliser dans un projet ?
    > Dans l'onglet File>Project Structure>Project, il est possible de configurer la JDK utilisée dans *Project SDK*.
1. Comment préciser la version Java des sources dans un projet ?
    > Dans l'onglet File>Project Structure>Project, il est possible de configurer le langage Java des modules dans *Project language level*.
1. Comment ajouter une bibliothèque externe dans un projet ?
    > Depuis File>Project Settings>Libraries, il est possible d'ajouter, modifier et supprimer des librairies externes.
1. Comment reformater un fichier source Java ?
    > Depuis Code>Reformate Code, il est possible de réarranger le code ou d'optimiser les imports du fichier source.
1. Comment trouver la déclaration d'une variable ou méthode ?
    > Par un clic-droit sur l'appel de cette variable ou méthode, l'option Go to...>Declaration est proposée ou alors le raccourci clavier ` Ctrl+B ` .
1. Comment insérer un bloc de code prédéfini (*snippet*) ?
    > Par un clic-droit dans la fenêtre de la classe java ou par l'onglet Code, on accède à l'option *Generate* qui propose différents blocs de code prédéfinit pour la classe courante.
1. Comment renommer une classe dans l'ensemble du projet ?
    > Par l'onglet Refactor>Rename..., ou par le raccourci clavier `Maj+F6` sur le nom de la classe, le changement se répendra dans tout le projet à toutes les récurrences du nom changé.
1. Comment exécuter le programme en lui passant un paramètre en ligne de commande ?
    > Dans l'onglet Run>Edit Configurations..., on accède à une fenêtre de paramètrage. La ligne *Programm arguments* permet de rentrer des paramètres qui seront utilisé en argument de la méthode main spécifié dans cette fenêtre. 
1. Comment déboguer le programme en visualisant le contenu d'une ou plusieurs variables ?
    > En utilisant l'onglet *Run>Debug...*, on lance la méthode main sélectionnée en marquant des arrêts sur les breackpoints notifiés par des ronds sur la marge gauche du code. On ajoute les breakpoints par un clic-gauche dans la marge et on les paramètres par un clic-droit sur le rond rouge apparu. La console du debogueur affiche les valeurs des variables, qui sont aussi en italique sur le code.
1. Quels paramètres ou fonctionnalités vous semblent particulièrement importants/utiles pour le développement Java ?
    > Il me semble que l'auto-complétion de code par l'ajout des imports et la gestion des packages est très pratique pour le développement en Java en plus des fonctionnalités cités plutôt.
