/*
 * Name: {TUChartImpl.js}
 * Module: {}
 * Location: {Norris/test/unit}
 * Date: {2015-05-25}
 * Version: {v0.1}
 *
 * History:
 *
 * ================================================================================
 * Version Date Programmer Changes
 * ================================================================================
 * 0.01 2015-05-25 Kaizen Team {creation}
 * ================================================================================
 */


describe('ChartImpl', function(){
    beforeEach(module('chuck-chart'));

    var ChartImpl;

    beforeEach(inject(function($injector) {
        ChartImpl = $injector.get('ChartImpl');
    }));

    describe('registerFactory(chartType: String, factory: ChartFactory): void',function(){
        it('should register the correspondence between a type of chart and its factory',function(){
            var chart = new ChartImpl('table','RandomID');
            var factory = {'method1':'RandomMethod1', 'method2':'RandomMethod2', 'attribute':'RandomAttribute'};
            ChartImpl.registerFactory('mapchart',factory);
            expect(factory).toEqual(chart.factories['mapchart']);
        });
    });

    describe('registerUpdater(updateType: String, updater: ChartUpdater): void',function(){
        it('should register the correspondence between a type of chart and its updater',function(){
            var chart = new ChartImpl('table','RandomID');
            var updater = {'method1':'RandomMethod1', 'method2':'RandomMethod2', 'attribute':'RandomAttribute'};
            ChartImpl.registerUpdater('inplace',updater);
            expect(updater).toEqual(chart.updaters['inplace']);
        });
    });

    describe('createChart(chartType: String, chartId: String): ChartImpl',function(){
        it('should allow you to create a chart only if its type is registered in the "factories" attribute', function(){
            var factory = {};
            factory.createChart = function(id) {return 'factoryReturn';}; 
            ChartImpl.registerFactory('barchart',factory);
            expect('factoryReturn').toEqual(ChartImpl.createChart('barchart','randomID'));
            expect(ChartImpl.createChart('randomType','randomID')).toBeNull();
        });
    });

    describe('ChartImpl(chartType: String, chartId: String)', function(){
        it('should memorize the right type of the chart',function(){
            expect('barchart').toEqual((new ChartImpl('barchart','randomID')).type);
        });
        it('should memorize the right id of the chart',function(){
            expect('randomID').toEqual((new ChartImpl('barchart','randomID')).uid);
        });
        it('should memorize an empty title for the chart',function(){
            expect('').toEqual((new ChartImpl('barchart','randomID')).settings.title);
        });
        it('should memorize "This is a chart." as a description for the chart',function(){
            expect('This is a chart.').toEqual((new ChartImpl('barchart','randomID')).settings.description);
        });
        it('should memorize no data',function(){
            expect(0).toEqual(Object.keys(new ChartImpl('barchart','randomID').data).length);
        });
    });

    describe('getId(): String', function(){
        it('should return the ID of the chart', function(){
            expect('randomID').toEqual((new ChartImpl('barchart','randomID')).getId());
        });
    });

    describe('getType(): String', function(){
        it('should return the type of the chart', function(){
            expect('linechart').toEqual((new ChartImpl('linechart','0123')).getType());
            expect('barchart').toEqual((new ChartImpl('barchart','3210')).getType());
            expect('mapchart').toEqual((new ChartImpl('mapchart','0132')).getType());
            expect('table').toEqual((new ChartImpl('table','2301')).getType());
        });
    });

    describe('setData(data: ChartData): void', function(){
        it('should set "data" parameter as data object in the chart', function(){
            var data = {'randomKey1':'randomValue1', 'randomKey2':'randomValue2'};
            var chart = new ChartImpl('linechart','randomID');
            chart.setData(data);
            expect(data).toEqual(chart.data);
        });
    });

    describe('getData(): ChartData', function(){
        it('should return the data object of the chart',function(){
            var chart = new ChartImpl('linechart','randomID');
            chart.data = {'randomKey1':'randomValue1', 'randomKey2':'randomValue2'};
            expect(chart.data).toEqual(chart.getData());
        });
    });

    describe('setSettings(settings: ChartSettings): void', function(){
        it('should set "settings" parameter as settings object in the chart (keys different from "title" and "description" are ignored)', function(){
            var settings = {'randomKey1':'randomValue1', 'randomKey2':'randomValue2'};
            var chart = new ChartImpl('linechart','randomID');
            chart.setSettings(settings);
            expect(settings).not.toEqual(chart.settings);
            settings = {'title':'randomTitle', 'description':'randomDescription'};
            chart.setSettings(settings);
            expect(settings).toEqual(chart.settings);
        });
    });

    describe('getSettings(): ChartSettings', function(){
        it('should return the settings object of the chart',function(){
            var settings = {'randomKey1':'randomValue1', 'randomKey2':'randomValue2'};
            var chart = new ChartImpl('linechart','randomID');
            chart.settings = settings;
            expect(chart.settings).toEqual(chart.getSettings());
        })
    });

});