DOCUMENTI =	AnalisiDeiRequisiti \
		DefinizioneDiProdotto \
		Glossario \
		NormeDiProgetto \
		PianoDiProgetto \
		PianoDiQualifica \
		SpecificaTecnica \
		StudioDiFattibilita


all: $(DOCUMENTI) LetteraDiPresentazione NorrisUserManual

LetteraDiPresentazione: _force
	@ make $@/$@.pdf

NorrisUserManual: _force
	@ #creazione file latex
	@ xmllint --noout --schema Commons/Document.xsd NorrisUserManual/NorrisUserManual.xml
	@ xsltproc -o NorrisUserManual/NorrisUserManual.tex NorrisUserManual/NorrisUserManual.xsl NorrisUserManual/NorrisUserManual.xml

	@ #creazione file latex termini
	@ xmllint --noout --schema NorrisUserManual/Termini.xsd NorrisUserManual/Termini.xml
	@ echo '\level{1}{Glossary}' > NorrisUserManual/Termini.tex
	@ echo '\\indent' >> NorrisUserManual/Termini.tex
	@ echo '\\vspace{1cm}' >> NorrisUserManual/Termini.tex
	@ xsltproc NorrisUserManual/Termini.xsl NorrisUserManual/Termini.xml >> NorrisUserManual/Termini.tex

	@ #compilazione file latex
	@ make $@/$@.pdf

$(DOCUMENTI): _force
	@ #creazione file latex
	@ xmllint --noout --schema Commons/Document.xsd $@/$@.xml
	@ xsltproc -o $@/$@.tex Commons/Document.xsl $@/$@.xml

	@ #documenti specifici
	@ test "$@" != "AnalisiDeiRequisiti" || make _analisi
	@ test "$@" != "DefinizioneDiProdotto" || make _definizione
	@ test "$@" != "Glossario" || make _glossario
	@ test "$@" != "NormeDiProgetto" || make _norme
	@ test "$@" != "PianoDiQualifica" || make _qualifica
	@ test "$@" != "SpecificaTecnica" || make _specifica
	@ test "$@" != "StudioDiFattibilita" || make _studio
	
	@ #compilazione file latex
	@ make $@/$@.pdf

_analisi: _force
	@ #creazione file latex usecase
	@ find AnalisiDeiRequisiti/UseCase -name '*.xml' | xargs -I {} xmllint --noout --schema AnalisiDeiRequisiti/UseCase/UC.xsd {}
	@ find AnalisiDeiRequisiti/UseCase -name '*.xml' | grep -Eo '[^/]*$$' | grep -Eo '^[^.]*' | xargs -I {} xsltproc -o AnalisiDeiRequisiti/UseCase/{}.tex AnalisiDeiRequisiti/UseCase/UC.xsl AnalisiDeiRequisiti/UseCase/{}.xml
	@ find AnalisiDeiRequisiti/UseCase -name '*.tex' | grep -Eo '[^/]*$$' | grep -Eo '^[^.]*' | xargs -I {} sed -ri 's/%filename%/{}/g' AnalisiDeiRequisiti/UseCase/{}.tex
	
	@ #concatenazione file
	@ find AnalisiDeiRequisiti/UseCase -name '*.tex' | grep -Eo '[^/]*$$' | grep -Eo '^UCN[0-9][^.]*' | sort -k 14 | sort -k 13 | sort -k 12 | sort -k 11 | sort -k 10 | sort -k 9 | sort -k 8 | sort -k 7 | sort -k 6 | sort -k 5 |sort -k 4 | xargs -I {} cat AnalisiDeiRequisiti/UseCase/{}.tex > AnalisiDeiRequisiti/UseCase/UCN.tex
	@ find AnalisiDeiRequisiti/UseCase -name '*.tex' | grep -Eo '[^/]*$$' | grep -Eo '^UCA[0-9][^.]*' | sort -k 14 | sort -k 13 | sort -k 12 | sort -k 11 | sort -k 10 | sort -k 9 | sort -k 8 | sort -k 7 | sort -k 6 | sort -k 5 |sort -k 4 | xargs -I {} cat AnalisiDeiRequisiti/UseCase/{}.tex > AnalisiDeiRequisiti/UseCase/UCA.tex
	@ find AnalisiDeiRequisiti/UseCase -name '*.tex' | grep -Eo '[^/]*$$' | grep -Eo '^UCD[0-9][^.]*' | sort -k 14 | sort -k 13 | sort -k 12 | sort -k 11 | sort -k 10 | sort -k 9 | sort -k 8 | sort -k 7 | sort -k 6 | sort -k 5 |sort -k 4 | xargs -I {} cat AnalisiDeiRequisiti/UseCase/{}.tex > AnalisiDeiRequisiti/UseCase/UCD.tex
	
	@ #download tabelle
	@ curl http://kaizenteam.it/tracker/export/fonti.php > AnalisiDeiRequisiti/TrackerFonti.tex
	@ curl http://kaizenteam.it/tracker/export/requisiti.php > AnalisiDeiRequisiti/TrackerRequisiti.tex
	@ curl http://kaizenteam.it/tracker/export/requisiti-fonti.php > AnalisiDeiRequisiti/TrackerRequisitiFonti.tex
	@ curl http://kaizenteam.it/tracker/export/fonti-requisiti.php > AnalisiDeiRequisiti/TrackerFontiRequisiti.tex
	@ curl http://kaizenteam.it/tracker/export/riepilogo.php > AnalisiDeiRequisiti/TrackerRiepilogo.tex

_definizione: _force
	@ #creazione file latex classi
	@ xsltproc DefinizioneDiProdotto/Classi/ClassiDefinizione.xsl Commons/Classi/Norris.xml | perl -MURI::Escape -e 'print uri_unescape(<STDIN>);' > DefinizioneDiProdotto/Classi/Norris.tex
	@ xsltproc DefinizioneDiProdotto/Classi/ClassiDefinizione.xsl Commons/Classi/Chuck.xml | perl -MURI::Escape -e 'print uri_unescape(<STDIN>);' > DefinizioneDiProdotto/Classi/Chuck.tex
	@ xsltproc DefinizioneDiProdotto/Classi/ClassiDefinizione.xsl Commons/Classi/Applicazione.xml | perl -MURI::Escape -e 'print uri_unescape(<STDIN>);' > DefinizioneDiProdotto/Classi/Applicazione.tex
	@ xsltproc DefinizioneDiProdotto/Classi/ClassiAggiuntive.xsl Commons/Classi/NorrisAggiuntive.xml | perl -MURI::Escape -e 'print uri_unescape(<STDIN>);' > DefinizioneDiProdotto/Classi/NorrisAggiuntive.tex
	@ xsltproc DefinizioneDiProdotto/Classi/ClassiAggiuntive.xsl Commons/Classi/ApplicazioneAggiuntive.xml | perl -MURI::Escape -e 'print uri_unescape(<STDIN>);' > DefinizioneDiProdotto/Classi/ApplicazioneAggiuntive.tex

	@ #escape caratteri
	@ sed -ri 's/\$$/\\\$$/gi;s/_/\\_/gi' DefinizioneDiProdotto/Classi/Norris.tex
	@ sed -ri 's/\$$/\\\$$/gi;s/_/\\_/gi' DefinizioneDiProdotto/Classi/Chuck.tex
	@ sed -ri 's/\$$/\\\$$/gi;s/_/\\_/gi' DefinizioneDiProdotto/Classi/Applicazione.tex

	@ #download tabelle
	@ curl http://kaizenteam.it/tracker/export/classi-requisiti.php > DefinizioneDiProdotto/TrackerClassiRequisiti.tex
	@ curl http://kaizenteam.it/tracker/export/requisiti-classi.php > DefinizioneDiProdotto/TrackerRequisitiClassi.tex

_glossario: _force
	@ #creazione file latex termini
	@ xmllint --noout --schema Glossario/Termini.xsd Glossario/Termini.xml
	@ xsltproc -o Glossario/Termini.tex Glossario/Termini.xsl Glossario/Termini.xml

	@ #eliminazione toc, lot, lof
	@ sed -ri 's/\\tableofcontents//;s/\\listoftables//;s/\\listoffigures//' Glossario/Glossario.tex

_norme: _force
	@ #eliminazione lot
	@ sed -ri 's/\\listoftables//' NormeDiProgetto/NormeDiProgetto.tex

_qualifica: _force
	@ curl http://kaizenteam.it/tracker/export/test-integrazione.php > PianoDiQualifica/Tex/TestIntegrazione.tex
	@ curl http://kaizenteam.it/tracker/export/test-integrazione_componenti.php > PianoDiQualifica/Tex/TracciamentoTestIntegrazioneClassiMetodi.tex
	@ curl http://kaizenteam.it/tracker/export/test-unita.php > PianoDiQualifica/Tex/TestUnita.tex
	@ curl http://kaizenteam.it/tracker/export/test-unita_metodi.php > PianoDiQualifica/Tex/TracciamentoTestUnitaClassiMetodi.tex
	@ curl http://kaizenteam.it/tracker/export/metodi_CN.php > PianoDiQualifica/TrackerMetricheCN.tex
	@ curl http://kaizenteam.it/tracker/export/metodi_A.php > PianoDiQualifica/TrackerMetricheA.tex

_specifica: _force
	@ #creazione file latex classi
	@ xsltproc SpecificaTecnica/Classi/ClassiSpecifica.xsl Commons/Classi/Norris.xml | perl -MURI::Escape -e 'print uri_unescape(<STDIN>);' > SpecificaTecnica/Classi/Norris.tex
	@ xsltproc SpecificaTecnica/Classi/ClassiSpecifica.xsl Commons/Classi/Chuck.xml | perl -MURI::Escape -e 'print uri_unescape(<STDIN>);' > SpecificaTecnica/Classi/Chuck.tex
	@ xsltproc SpecificaTecnica/Classi/ClassiSpecifica.xsl Commons/Classi/Applicazione.xml | perl -MURI::Escape -e 'print uri_unescape(<STDIN>);' > SpecificaTecnica/Classi/Applicazione.tex

	@ #escape caratteri
	@ sed -ri 's/\$$/\\\$$/gi' SpecificaTecnica/Classi/Norris.tex
	@ sed -ri 's/\$$/\\\$$/gi' SpecificaTecnica/Classi/Chuck.tex
	@ sed -ri 's/\$$/\\\$$/gi' SpecificaTecnica/Classi/Applicazione.tex

	@ #download tabelle
	@ curl http://kaizenteam.it/tracker/export/componenti-requisiti.php > SpecificaTecnica/TrackerComponentiRequisiti.tex
	@ curl http://kaizenteam.it/tracker/export/requisiti-componenti.php > SpecificaTecnica/TrackerRequisitiComponenti.tex

_studio: _force
	@ #eliminazione lot, lof
	@ sed -ri 's/\\listoftables//;s/\\listoffigures//' StudioDiFattibilita/StudioDiFattibilita.tex

%.pdf: _force
	@ export TEXINPUTS=":`dirname $*`:Commons"; pdflatex -output-directory `dirname $*` `echo $* | grep -Eo '[^/]*$$'`.tex
	@ export TEXINPUTS=":`dirname $*`:Commons"; pdflatex -output-directory `dirname $*` `echo $* | grep -Eo '[^/]*$$'`.tex
	@ export TEXINPUTS=":`dirname $*`:Commons"; pdflatex -output-directory `dirname $*` `echo $* | grep -Eo '[^/]*$$'`.tex

spell: _force
	@ find . -name '*.tex' -exec aspell --mode=tex --lang=it check {} \;
	@ find . -name '*.xml' -exec aspell --mode=tex --lang=it check {} \;
	@ find . -name '*.xsl' -exec aspell --mode=tex --lang=it check {} \;

gulpease: _force
	@ for doc in $(DOCUMENTI) ; do \
		find $$doc -name "*.tex" -exec cat {} + > gulpease.tmp; \
		echo "$$doc"; \
		./Commons/Script/Gulpease.sh gulpease.tmp; \
		echo ""; \
	done

	@ rm -f gulpease.tmp

glossary: terms = $(shell xmllint --xpath '//entry/@name' Glossario/Termini.xml | grep -o '"[[:alpha:]|\.| ]*"' | grep -o '[[:alpha:]|\.| ]*' | tr "\n" "|" | head -c -1 | sed 's/\./\\./g')
glossary: skip = ignoreglo|newcommand\{[^}]*\}|input|begin|end|level\{[^}]*\}|section|subsection|subsubsection|paragraph|subparagraph|insuri|inspath|insrole|insdoc|insfile|insrev|insphase|includegraphics[^{]*|caption|label|ref|nameref|pageref|hyperref|addtocounter|texttt
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

glossary-manual: terms = $(shell xmllint --xpath '//entry/@name' NorrisUserManual/Termini.xml | grep -o '"[[:alpha:]|\.| ]*"' | grep -o '[[:alpha:]|\.| ]*' | tr "\n" "|" | head -c -1 | sed 's/\./\\./g')
glossary-manual: skip = ignoreglo|newcommand\{[^}]*\}|input|begin|end|level\{[^}]*\}|section|subsection|subsubsection|paragraph|subparagraph|insuri|inspath|insrole|insdoc|insfile|insrev|insphase|includegraphics|includegraphics[^{]*|caption|label|ref|nameref|pageref|hyperref|addtocounter|texttt
glossary-manual: _force
	@ #eliminazione tag
	@ find NorrisUserManual -name '*.tex' -exec sed -ri 's/\\insglo\{([^\}]*)\}/\1/gi' {} \;
	@ #aggiunta tag
	@ find NorrisUserManual -name '*.tex' -exec sed -ri 's/\b($(terms))\b/\\insglo\{\1\}/gi' {} \;
	@ #eliminazione tag su parole comandi
	@ find NorrisUserManual -name '*.tex' -exec sed -ri 's/\\\\insglo\{($(terms))\}/\\\1/gi' {} \;
	@ #eliminazione tag su comandi skip
	@ find NorrisUserManual -name '*.tex' -exec sed -ri 's/(\\($(skip))\{[^}]*)\\insglo\{([^}]*)\}/\1\3/gi' {} \;
	@ find NorrisUserManual -name '*.tex' -exec sed -ri 's/(\\($(skip))\{[^}]*)\\insglo\{([^}]*)\}/\1\3/gi' {} \;
	@ find NorrisUserManual -name '*.tex' -exec sed -ri 's/(\\($(skip))\{[^}]*)\\insglo\{([^}]*)\}/\1\3/gi' {} \;
	@ find NorrisUserManual -name '*.tex' -exec sed -ri 's/(\\($(skip))\{[^}]*)\\insglo\{([^}]*)\}/\1\3/gi' {} \;
	@ find NorrisUserManual -name '*.tex' -exec sed -ri 's/(\\($(skip))\{[^}]*)\\insglo\{([^}]*)\}/\1\3/gi' {} \;
	
clean: _force
	@ rm -f AnalisiDeiRequisiti/UseCase/*.tex
	@ rm -f $(DOCUMENTI:%=%/*.tex)
	@ rm -f */Classi/*.tex

	@ rm -f */*.out */*.log */*.aux */*.toc */*.lof */*.lot

_force:
