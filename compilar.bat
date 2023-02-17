git clone https://github.com/SeckQ/Prueba1PD.git && cd ./Prueba1PD && cd ./app-authors && gradlew build && docker build -t jaimesalvador/app-authors:1.0 . && cd .. && cd ./app-books-main && gradlew jar && gradlew copyLibs && docker build -t jaimesalvador/app-books:1.0 . && cd .. && cd ./app-web && gradlew jar && gradlew copyLibs && docker build -t jaimesalvador/app-web:1.0 . && docker push jaimesalvador/app-web:1.0 && docker push jaimesalvador/app-books:1.0 && docker push jaimesalvador/app-authors:1.0 && cd .. && docker compose up
