DOCUMENTI =	AnalisiDeiRequisiti \
		Glossario \
		NormeDiProgetto \
		PianoDiProgetto \
		PianoDiQualifica \
		StudioDiFattibilita


all: $(DOCUMENTI)


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
	@ find AnalisiDeiRequisiti/UseCase -name '*.xml' | grep -Eo 'UC[0-9](\.[0-9])*' | sort -k 13 |sort -k 11 | sort -k 9 | sort -k 7 | sort -k 5 | sort -k 3 | sed 's/\(^.*$$\)/\1\.xml/g' | xargs -I {} xsltproc AnalisiDeiRequisiti/UseCase/UC.xsl AnalisiDeiRequisiti/UseCase/{} > AnalisiDeiRequisiti/UC.tex

	@ #download tabelle
	@ curl http://kaizenteam.it/tracker/export/fonti.php > AnalisiDeiRequisiti/Fonti.tex
	@ curl http://kaizenteam.it/tracker/export/requisiti.php > AnalisiDeiRequisiti/Requisiti.tex
	@ curl http://kaizenteam.it/tracker/export/requisiti-fonti.php > AnalisiDeiRequisiti/RequisitiFonti.tex

_glossario: _force
	@ #creazione file latex termini
	@ xmllint --noout --schema Glossario/Termini.xsd Glossario/Termini.xml
	@ xsltproc -o Glossario/Termini.tex Glossario/Termini.xsl Glossario/Termini.xml

	@ #eliminazione toc, lot, lof
	@ sed -i 's/\\tableofcontents//g;s/\\listoftables//g;s/\\listoffigures//g' Glossario/Glossario.tex

%.pdf: _force
	@ export TEXINPUTS=":`dirname $*`:Commons"; pdflatex -output-directory `dirname $*` `echo $* | grep -Eo '[^/]*$$'`.tex
	@ export TEXINPUTS=":`dirname $*`:Commons"; pdflatex -output-directory `dirname $*` `echo $* | grep -Eo '[^/]*$$'`.tex
	@ export TEXINPUTS=":`dirname $*`:Commons"; pdflatex -output-directory `dirname $*` `echo $* | grep -Eo '[^/]*$$'`.tex
	
clean: _force
	@ rm -f */*.tex */*.out */*.log */*.aux */*.toc */*.lof */*.lot

_force:
