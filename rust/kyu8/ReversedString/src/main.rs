fn solution(phrase: &str) -> String {
    phrase.chars().rev().collect()
}

#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn sample_test() {
        assert_eq!(solution("world"), "dlrow");
    }
}

/*
fn solution(phrase: &str) -> String {
    return phrase.chars().rev().collect::<String>();
}

Inférence de type vs. spécification explicite du type : La première version laisse le compilateur inférer que tu veux un String en utilisant collect(), tandis que la deuxième version spécifie explicitement le type avec collect::<String>().

Utilisation de return : La deuxième version utilise le mot-clé return, ce qui est redondant ici puisque Rust retourne automatiquement la dernière expression d'une fonction. La première version omet ce mot-clé, rendant le code plus court et plus idiomatique en Rust.

*/

/*
fn solution(phrase: &str) -> String {
    let mut s = phrase.to_string();
    let length = s.len();
    let mut res = String::with_capacity(length);
    for l in 0..length {
        res.insert(0, s.remove(0));
    }
    res
}

*/
