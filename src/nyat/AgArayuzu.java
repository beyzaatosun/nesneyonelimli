package nyat;

import java.util.Scanner;

public class AgArayuzu {

    public void Arayuz()
    {
        Scanner a = new Scanner(System.in);
        String KullaniciAdi;
        String Sifre;
        MerkeziIslemBirimi akilliCihaz = new MerkeziIslemBirimi();
        while(true)
        {
            System.out.print("Lütfen Kullanıcı Adınızı Giriniz : ");
            KullaniciAdi = a.next();
            System.out.print("Lütfen Şifrenizi Giriniz : ");
            Sifre = a.next();
            if(Veritabani.getInstance().Kontrol(KullaniciAdi , Sifre))
                break;
            else
                System.out.println("Hatalı Giriş Yaptınız.");
        }

        while(true)
        {
            byte secim;
            Scanner b = new Scanner(System.in);
            System.out.println("1-Sıcaklık Görüntüle");
            System.out.println("2-Soğutucu Aç");
            System.out.println("3-Soğutucu Kapat");
            System.out.println("4-Çıkış Yap");
            secim = b.nextByte();
            if(secim == 1)
            {
                akilliCihaz.sicaklikGoster();
            }
            if(secim == 2)
            {
                akilliCihaz.sogutucuAc();
            }
            if(secim == 3)
            {
                akilliCihaz.sogutucuKapat();
            }
            if(secim == 4)
            {
                System.exit(1);
            }

        }
    }
}
