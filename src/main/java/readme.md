Per te perdorur imazhe/fotografi ne JavaFX:

1. Se pari ne fajllin tone home.fxml (ose ndonje fajll tjeter) e krijojme komponentin ImageView, duke i vendosur nje fx:id = 'imageView' (shembull)

2. Tek folderi 'resources' e krijojme nje folder me emrin 'images' ku i vendosim te gjitha fotografite qe do ti perdorim ne programin tone

3. Te kontrolleri HomeController (pra kontrolleri i fajllit home.fxml) e deklarojme variablen imageView:
```java
   @FXML
   private ImageView imageView;
```

4. Te metoda initialize e lexojme fotografine permes klases Image dhe e vendosim ne variablen imageView. Kodi do te duket ne kete forme:
```java
public class ViewController implements Initializable {
    
        @FXML
        private ImageView imageView;
        
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            Image image = new Image(getClass().getResourceAsStream("/images/university_of_prishtina.png"));
            this.imageView.setImage(image);
        }
    }
```
    