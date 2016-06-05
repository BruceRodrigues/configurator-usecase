mvn clean install -f ~/dev/git/configurator-usecase/configurator.view/pom.xml
mvn clean install -f ~/dev/git/configurator/pom.xml
cp ~/.m2/repository/br/ufsc/usecase/configurator.view/1.0/configurator.view-1.0.jar ~/dev/git/configurator-usecase/UseCaseAndroid/app/libs/
cp ~/.m2/repository/br/ufsc/configurator/1.0/configurator-1.0.jar ~/dev/git/configurator-usecase/UseCaseAndroid/app/libs/
