class Test {
	public static void main(String[] args) {
		String[] reservert = {null, "Heidi", "Anne", null, "Heidi", null};
		Bord bord = new Bord(reservert);
		Restaurant r1 = new Restaurant("Max", 1997, bord);

		//Tester de ulike metodene:
		//Tester getNavn-metoden:
		System.out.println("Test 1: getNavn()");
		if (r1.getNavn().equals("Max")) {
			System.out.println("Vellykket");
		} else {
			System.out.println("Ikke vellykket");
		}

		System.out.println("Test 2: setNavn()");
		r1.setNavn("Max sin restaurant");
		if (r1.getNavn().equals("Max sin restaurant")) {
			System.out.println("Vellykket");
		} else {
			System.out.println("Ikke vellykket");
		}

		System.out.println("Test 3: getEtablert()");
		if (r1.getEtablert() == 1997) {
			System.out.println("Vellykket");
		} else {
			System.out.println("Ikke vellykket");
		}

		System.out.println("Test 4: finnAlder()");
		if (r1.finnAlder() == 22) {
			System.out.println("Vellykket");
		} else {
			System.out.println("Ikke vellykket");
		}

		System.out.println("Test 5: finnAntalLLedigBord()");
		if (r1.finnAntalLLedigBord() == 3) {
			System.out.println("Vellykket");
		} else {
			System.out.println("Ikke vellykket");
		}

		System.out.println("Test 5: finnAntallOpptattBord");
		if (r1.finnAntallOpptattBord() == 3) {
			System.out.println("Vellykket");
		} else {
			System.out.println("Ikke vellykket");
		}

		System.out.println("Test 6: reserverBord()");
		if (r1.reserverBord("Zaim", 2)) {
			System.out.println("Vellykket");
		} else {
			System.out.println("Ikke vellykket");
		}

		System.out.println("Test 7: reserverBord()");
		if (r1.reserverBord("Guri", 5)) {
			System.out.println("Ikke Vellykket");
		} else {
			System.out.println("Vellykket");
		}

		System.out.println("Test 8: finnAntallBord()");
		int[] test = r1.finnAntallBord("Heidi");
		String res ="";
		for (int i : test) {
			res += i + " ";
		}
		if (res.trim().equals("1 4")) {
			System.out.println("Vellykket");
		} else {
			System.out.println("Ikke vellykket");
		}








	}
}
