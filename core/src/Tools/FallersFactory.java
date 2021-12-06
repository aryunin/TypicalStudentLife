package Tools;

import Model.Book;
import Model.Bottle;
import Model.GameObject;

import static com.artemiiik.tsl.Main.random;

public enum FallersFactory implements EmptyFactory{
    BookFactory {
        @Override
        public GameObject create(float posX, float posY) {
            return new Book(posX, posY);
        }
    },
    BottleFactory {
        @Override
        public GameObject create(float posX, float posY) {
            return new Bottle(posX, posY);
        }
    };

    static public FallersFactory getRandomFactory() {
        return values()[random.nextInt(values().length)];
    }
}
