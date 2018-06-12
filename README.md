# FORSETI SERVER

Backend for FORSETI project.

## Running Server

### Prerequisits

1. JAVA installed properly
2. MongoDB is running _(**version 3.6** works, not sure about others)_ [TUTORIAL](https://docs.mongodb.com/manual/tutorial/install-mongodb-on-windows)

### Steps

1. Navigate into project directory 
2. Execute `gradlew bootRun`
3. Have fun on port `8080`
4. When done, panic `CTRL+C` is the way to go

## Rest API documentation

1. Run server as shown above
2. Go to `/swagger-ui.html`
3. Enjoy

## Generating data

Execute **GET** request to `/dev/generate`. There is some degree of customizing generation process. Parameters can be seen in swagger documentation.

## Nice to have
1. Using terminal for everything is cool, but You may find having Robo3T as MongoGUI attractive alternative [DOWNLOAD](https://robomongo.org/download)

## Sort codes for banks
In `resources/number_details_processed.csv` file there is a file with sort codes for most of polish banks with some details about them. It probably still contains error and some extra fields. It would be appreciated if someone would perfect it.
