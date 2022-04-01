package pl.drekurion.bookstoreapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.drekurion.bookstoreapi.author.Author;
import pl.drekurion.bookstoreapi.author.AuthorRepository;
import pl.drekurion.bookstoreapi.book.Book;
import pl.drekurion.bookstoreapi.book.BookRepository;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class BookstoreApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApiApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AuthorRepository authorRepository, BookRepository bookRepository) {
		return args -> {

			Author author1 = new Author(1L, "Charlaine", "Harris");
			Author author2 = new Author(2L, "Mario", "Vargas Llosa");

			authorRepository.saveAll(List.of(author1, author2));

			Book book1 = new Book(
					"Gorzej niż martwy",
					"Już nie tylko perypetie miłosne, nie tylko sprawy żywych i martwych ale również huragan Katrina zagraża porządkowi świata Sookie Stackhouse, obdarzonej darem telepatii, sympatycznej kelnerki z małego miasteczka Bon Temps z Południa Stanów. Gorzej niż martwy, 8 powieść z serii Sookie Stackhouse (bez zbioru opowiadań Dotyk Martwych).\r\n\r\nSpołeczność nadnaturalnych z luizjańskiego Bon Temps przeżyła ostatnio wiele nieprzyjemnych zdarzeń: z jednej strony dały o sobie znać potężne siły natury, czyli niszczycielski huragan Katrina, z drugiej, aktu nienawiści dokonali ludzie, którzy podłożyli bomby w hotelu w Rhodes, gdzie odbywało się wampirze spotkanie na szczycie. Sookie Stackhouse jest bezpieczna, lecz poruszona, zaszokowana i zmęczona - z całych sił pragnie powrotu do normalności. Niestety, sytuacja stale się pogarsza. Zbyt wiele wampirów (w tym liczni przyjaciele Sookie) zginęło w Rhodes lub zmarło z powodu odniesionych tam ran. A po chłopaku telepatki, tygrysołaku Quinnie, słuch zaginął. Świat wokół zmienia się, nawet jeśli nie podoba się to wampirom czy zmiennokształtnym. W dodatku Sookie, Przyjaciółka Wilkołaczego Stada, telepatka połączona więzią krwi z przywódcą społeczności lokalnych nieumarłych, trafia w sam środek tych przemian. Grozi jej niebezpieczeństwo i śmierć oraz - nie po raz pierwszy - doświadcza zdrady ze strony kogoś, kogo pokochała. I chociaż w końcu opada bitewny kurz, a przedstawiciele różnych społeczności zawierają przymierza, świat Sookie nigdy nie będzie już taki jak przed Katriną. Charlaine Harris jest fenomenem literackim w Stanach Zjednoczonych. Jako jedyna autorka wprowadziła jednocześnie 7 tytułów serii na listę bestsellerów New York Times. Serial Czysta Krew był dwukrotnie nominowany do Złotych Globów a reżyserii podjął się laureat Oscara Alan Ball. Sookie Stackhouse gra laureatka Oscara Anna Paquin, która za rolę Sookie otrzymała Złoty Glob.",
					new BigDecimal("29.24"),
					446,
					null
			);
			Book book2 = new Book(
					"Marzenie celta",
					"Co by się stało, gdyby Roger Casement nie spotkał nigdy Josepha Conrada?\r\n\r\nMoże nie trafiłby do więzienia, może jego własna podróż do jądra ciemności nie byłaby taka tragiczna? Słynny twórca raportu z czarnego Kongo, który uświadomił światu barbarzyństwo uprawiane przez białego człowieka w Afryce, znalazł się w niełasce. Dlaczego? Odpowiedzi jest kilka, ale ta najprawdziwsza kryje w sobie niechlubną tajemnicę. Bohater powieści podczas śledztwa w Afryce odkrywa nie tylko bestialskie okrucieństwo ludzi, którzy w imię moralnej przewagi katują i mordują swoich podwładnych, 'swoją własność'. Za tymi karygodnymi czynami kryje się coś znacznie więcej, przerażająca prawda, która będzie go już zawsze prześladować - pod powierzchnią kultury i cywilizacji ukrywa się potwór, potwór, który zagraża i jemu samemu. Kiedy sam w sobie odkryje ciemne strony homoseksualizmu, z którym długo przyjdzie mu walczyć, zmieni się cały jego świat. Oskarżony o zdradę i osadzony w więzieniu, zaczyna opowiadać swoją historię. Mówi o dzieciństwie spędzonym w Irlandii, o matce, która potajemnie go ochrzciła, o ojcu, który oszalał z rozpaczy po jej śmierci. O idealizmie, z jakim wyruszył na wyprawę do Afryki. O pięknych czarnych tragarzach, których fotografował, i o swoim seksualnym wyzwoleniu w Brazylii. To właśnie jego dzienniki z wypraw z bulwersującymi homoseksualnymi zapiskami przyczynią się do podjęcia ostatecznej decyzji rządu o karze śmierci dla Rogera Casementa. Listu w jego obronie nie podpisze nawet jego przyjaciel Joseph Conrad. Kim był Roger Casement? Bohaterem czy zdrajcą? Idealistą czy realistą? Osobą moralną czy niemoralną?",
					new BigDecimal("37.79"),
					472,
					null
			);
			bookRepository.saveAll(List.of(book1, book2));
		};
	}
}
