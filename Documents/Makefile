DOCUMENTI =	AnalisiDeiRequisiti \
		Glossario \
		NormeDiProgetto \
		PianoDiProgetto \
		PianoDiQualifica \
		StudioDiFattibilita


all: $(DOCUMENTI) LetteraDiPresentazione

LetteraDiPresentazione: _force
	@ make $@/$@.pdf


$(DOCUMENTI): _force
	@ #creazione file latex
	@ xmllint --noout --schema Commons/Document.xsd $@/$@.xml
	@ xsltproc -o $@/$@.tex Commons/Document.xsl $@/$@.xml

	@ #documenti specifici
	@ test "$@" = "Glossario" && make _glossario; exit 0
	@ test "$@" = "AnalisiDeiRequisiti" && make _analisi; exit 0

	@ #compilazione file latex
	@ make $@/$@.pdf

_analisi: _force
	@ #creazione file latex usecase
	@ find AnalisiDeiRequisiti/UseCase -name '*.xml' -exec xmllint --noout --schema AnalisiDeiRequisiti/UseCase/UC.xsd {} \;
	@ find AnalisiDeiRequisiti/UseCase -name '*.xml' | grep -Eo '[^/]*$$' | grep -Eo '^[^.]*' | xargs -I {} xsltproc -o AnalisiDeiRequisiti/UseCase/{}.tex AnalisiDeiRequisiti/UseCase/UC.xsl AnalisiDeiRequisiti/UseCase/{}.xml
	@ find AnalisiDeiRequisiti/UseCase -name '*.tex' | grep -Eo '[^/]*$$' | grep -Eo '^[^.]*' | xargs -I {} sed -ri 's/%filename%/{}/g' AnalisiDeiRequisiti/UseCase/{}.tex
	
	@ #concatenazione file
	@ find AnalisiDeiRequisiti/UseCase -name '*.tex' | grep -Eo '[^/]*$$' | grep -Eo '^UCN[0-9][^.]*' | sort -k 12 | sort -k 10 | sort -k 8 | sort -k 6 | sort -k 4 | xargs -I {} cat AnalisiDeiRequisiti/UseCase/{}.tex > AnalisiDeiRequisiti/UseCase/UCN.tex
	@ find AnalisiDeiRequisiti/UseCase -name '*.tex' | grep -Eo '[^/]*$$' | grep -Eo '^UCA[0-9][^.]*' | sort -k 12 | sort -k 10 | sort -k 8 | sort -k 6 | sort -k 4 | xargs -I {} cat AnalisiDeiRequisiti/UseCase/{}.tex > AnalisiDeiRequisiti/UseCase/UCA.tex
	@ find AnalisiDeiRequisiti/UseCase -name '*.tex' | grep -Eo '[^/]*$$' | grep -Eo '^UCD[0-9][^.]*' | sort -k 12 | sort -k 10 | sort -k 8 | sort -k 6 | sort -k 4 | xargs -I {} cat AnalisiDeiRequisiti/UseCase/{}.tex > AnalisiDeiRequisiti/UseCase/UCD.tex
	
	@ #download tabelle
	@ curl http://kaizenteam.it/tracker/export/fonti.php > AnalisiDeiRequisiti/TrackerFonti.tex
	@ curl http://kaizenteam.it/tracker/export/requisiti.php > AnalisiDeiRequisiti/TrackerRequisiti.tex
	@ curl http://kaizenteam.it/tracker/export/requisiti-fonti.php > AnalisiDeiRequisiti/TrackerRequisitiFonti.tex
	@ curl http://kaizenteam.it/tracker/export/fonti-requisiti.php > AnalisiDeiRequisiti/TrackerFontiRequisiti.tex
	@ curl http://kaizenteam.it/tracker/export/riepilogo.php > AnalisiDeiRequisiti/TrackerRiepilogo.tex	

_glossario: _force
	@ #creazione file latex termini
	@ xmllint --noout --schema Glossario/Termini.xsd Glossario/Termini.xml
	@ xsltproc -o Glossario/Termini.tex Glossario/Termini.xsl Glossario/Termini.xml

	@ #eliminazione toc, lot, lof
	@ sed -ri 's/\\tableofcontents//g;s/\\listoftables//g;s/\\listoffigures//g' Glossario/Glossario.tex

%.pdf: _force
	@ export TEXINPUTS=":`dirname $*`:Commons"; pdflatex -output-directory `dirname $*` `echo $* | grep -Eo '[^/]*$$'`.tex
	@ export TEXINPUTS=":`dirname $*`:Commons"; pdflatex -output-directory `dirname $*` `echo $* | grep -Eo '[^/]*$$'`.tex
	@ export TEXINPUTS=":`dirname $*`:Commons"; pdflatex -output-directory `dirname $*` `echo $* | grep -Eo '[^/]*$$'`.tex

spell: _force
	@ find . -name '*.tex' -exec aspell --mode=tex --lang=it check {} \;

gulpease: chars = 1
gulpease: words = 1
gulpease: sentences = 1
gulpease: _force
	@ exit 1

glossary: terms = $(shell xmllint --xpath '//entry/@name' Glossario/Termini.xml | grep -o '"[[:alpha:]|\.]*"' | grep -o '[[:alpha:]|\.]*' | tr "\n" "|" | head -c -1 | sed 's/\./\\./g')
glossary: skip = ignoreglo|newcommand\{[^}]*\}|input|begin|end|section|subsection|subsubsection|paragraph|subparagraph|insuri|inspath|insrole|insdoc|insfile|insrev|insphase|includegraphics[^{]*|caption|label|ref|nameref|pageref|hyperref
glossary: _force
	@ #eliminazione tag
	@ find $(DOCUMENTI) Commons -name '*.tex' -exec sed -ri 's/\\insglo\{([^\}]*)\}/\1/gi' {} \;
	@ #aggiunta tag
	@ find $(DOCUMENTI) Commons -name '*.tex' -exec sed -ri 's/\b($(terms))\b/\\insglo\{\1\}/gi' {} \;
	@ #eliminazione tag su parole comandi
	@ find $(DOCUMENTI) Commons -name '*.tex' -exec sed -ri 's/\\\\insglo\{($(terms))\}/\\\1/gi' {} \;
	@ #eliminazione tag su comandi skip
	@ find $(DOCUMENTI) Commons -name '*.tex' -exec sed -ri 's/(\\($(skip))\{[^}]*)\\insglo\{([^}]*)\}/\1\3/gi' {} \;
	@ find $(DOCUMENTI) Commons -name '*.tex' -exec sed -ri 's/(\\($(skip))\{[^}]*)\\insglo\{([^}]*)\}/\1\3/gi' {} \;
	@ find $(DOCUMENTI) Commons -name '*.tex' -exec sed -ri 's/(\\($(skip))\{[^}]*)\\insglo\{([^}]*)\}/\1\3/gi' {} \;
	@ find $(DOCUMENTI) Commons -name '*.tex' -exec sed -ri 's/(\\($(skip))\{[^}]*)\\insglo\{([^}]*)\}/\1\3/gi' {} \;
	@ find $(DOCUMENTI) Commons -name '*.tex' -exec sed -ri 's/(\\($(skip))\{[^}]*)\\insglo\{([^}]*)\}/\1\3/gi' {} \;
	
clean: _force
	@ rm -f AnalisiDeiRequisiti/UseCase/*.tex
	@ rm -f $(DOCUMENTI:%=%/*.tex)

	@ rm -f */*.out */*.log */*.aux */*.toc */*.lof */*.lot

_force:
