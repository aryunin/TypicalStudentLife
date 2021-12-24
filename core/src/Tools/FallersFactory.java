package Tools;

import Model.GameObjects.*;

import static com.artemiiik.tsl.TSL.random;

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
    },
    CigaretteFactory {
        @Override
        public GameObject create(float posX, float posY) {
            return new Cigarette(posX, posY);
        }
    },
    RecordBookFactory {
        @Override
        public GameObject create(float posX, float posY) {
            return new RecordBook(posX, posY);
        }
    },
    FeatherFactory {
        @Override
        public GameObject create(float posX, float posY) {
            return new Feather(posX, posY);
        }
    };

    static public FallersFactory getRandomFactory() {
        return values()[random.nextInt(values().length)];
    }
}
