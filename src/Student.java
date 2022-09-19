public class Student {
    String name,stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    double avarage, fizAvg, matAvg, kimAvg;
    boolean isPass;


    Student(String name, int classes, String stuNo, Course mat,Course fizik,Course kimya) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        calcAvarage();
        this.isPass = false;
    }


    public void addBulkExamNote(int mat, int fizik, int kimya) {

        if (mat >= 0 && mat <= 100) {
            this.mat.note = mat;
        }

        if (fizik >= 0 && fizik <= 100) {
            this.fizik.note = fizik;
        }

        if (kimya >= 0 && kimya <= 100) {
            this.kimya.note = kimya;
        }

    }

    public void addBulkVerbalNote(int mat, int fizik, int kimya) {

        if (mat >= 0 && mat <= 100) {
            this.mat.verbalNote = mat;
        }

        if (fizik >= 0 && fizik <= 100) {
            this.fizik.verbalNote = fizik;
        }

        if (kimya >= 0 && kimya <= 100) {
            this.kimya.verbalNote = kimya;
        }

    }

    public void isPass() {
        if (this.mat.note == 0 || this.fizik.note == 0 || this.kimya.note == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAvarage() {
        this.matAvg= (this.mat.note*(1- this.mat.verbalRatio)+(this.mat.verbalNote*this.mat.verbalRatio));
        this.fizAvg= (this.fizik.note*(1- this.fizik.verbalRatio)+(this.fizik.verbalNote*this.fizik.verbalRatio));
        this.kimAvg= (this.kimya.note*(1- this.kimya.verbalRatio)+(this.kimya.verbalNote*this.kimya.verbalRatio));
        this.avarage = (this.matAvg + this.fizAvg + this.kimAvg) / 3;
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    public void printNote(){
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.matAvg);
        System.out.println("Fizik Notu : " + this.fizAvg);
        System.out.println("Kimya Notu : " + this.kimAvg);
    }
}
