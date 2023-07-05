package org.example.enumsAndAnnotations.builderPattern;


public class Person {
    private String nume;
    private String varsta;
    private String job;
    private String universitate;

    private boolean esteCasatorita;
    

    
    public Person(Builder builder) {
        this.nume = builder.nume;
        this.esteCasatorita = builder.esteCasatorita;
        this.job = builder.job;
        this.universitate = builder.universitate;
    }

    public void getNume() {
    }


    static class Builder {
        private String nume;
        private String varsta;
        private String job;
        private String universitate;

        private boolean esteCasatorita;
        
        public Builder(String nume) {
            this.nume = nume;
        }

        public Builder varsta (String varsta) {
            this.varsta = varsta;
            return this;
        }

        public Builder job (String job) {
            this.job = job;
            return this;
        }

        public Builder universitate (String universitate) {
            this.universitate = universitate;
            return this;
        }

        public Builder esteCasatorit(boolean esteCasatorita) {
            this.esteCasatorita = esteCasatorita;
            return this;
        }
        
        public Person buid(){
            return new Person(this);
        }

    }
}
