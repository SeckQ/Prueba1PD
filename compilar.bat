git clone https://github.com/SeckQ/DbrProDist1.git && cd ./DbrProDist1 && cd ./app-authors && gradlew build && docker build -t jaimesalvador/app-authors:2.0 . && cd .. && cd ./app-books && gradlew jar && gradlew copyLibs && docker build -t jaimesalvador/app-books:2.0 . && cd .. && cd ./app-web && gradlew jar && gradlew copyLibs && docker build -t jaimesalvador/app-web:2.0 . && docker push jaimesalvador/app-web:2.0 && docker push jaimesalvador/app-books:2.0 && docker push jaimesalvador/app-authors:2.0 && cd .. && docker compose up