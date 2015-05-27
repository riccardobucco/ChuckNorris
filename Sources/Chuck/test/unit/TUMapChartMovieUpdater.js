/*
 * Name: {TUMapChartMovieUpdater.js}
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

describe('MapChartMovieUpdater', function(){
    beforeEach(module('norris-chartupdater'));

    var MapChartMovieUpdater;
    
    beforeEach(inject(function($injector) {
        MapChartMovieUpdater = $injector.get('MapChartMovieUpdater');
    }));

    describe('update(chart: ChartImpl, updateData: ChartUpdate): void', function(){
        it('should reject chart without data',function(){
            var chart = {data: {}};
            chart.getData = function() {return this.data;};
            chart.setData = function(data) {this.data = data;};
            var newData = {
                inplace : [
                    { position: {series:0, index:0}, data: {x:1, y:1} },
                    { position: {series:0, index:1}, data: {x:1, y:1} }
                ],
                stream: [
                    { values: [{x:11, y:11}, {x:22, y:22}, {x:33, y:33}, {x:44, y:44}] },
                ],
                delete: [
                    {series:0, index:0},
                    {series:0, index:1}
                ]
            };
            expect(function () {(new MapChartMovieUpdater()).update(chart, newData)}).toThrow();
        });
        it('should update a given mapchart with the movie method',function(){
            var chart = {
                data: [
                    {values: [{x:0, y:1}, {x:2, y:3}, {x:4, y:5}, {x:6, y:7}]},
                    {values: [{x:8, y:9}, {x:10, y:12}, {x:12, y:13}, {x:14, y:15}]},
                    {values: [{x:16, y:17}, {x:18, y:19}, {x:20, y:21}, {x:22, y:23}]}
                ]
            };
            chart.getData = function() {return this.data;};
            chart.setData = function(par) {this.data = par;};
            var newData = {
                inplace : [
                    { position: {series:0, index:0}, data: {x:9999, y:9999} },
                    { position: {series:0, index:1}, data: {x:8888, y:8888} }
                ],
                stream: [
                    { values: [{x:66, y:66}, {x:666, y:666}, {x:6666, y:6666}, {x:66666, y:66666}] },
                ],
                delete: [
                    {series:1, index:0},
                    {series:2, index:1}
                ]
            };
            var updatedData =  [
                {values: [{x:9999, y:9999}, {x:8888, y:8888}, {x:4, y:5}, {x:6, y:7}]},
                {values: [{x:10, y:12}, {x:12, y:13}, {x:14, y:15}]},
                {values: [{x:16, y:17}, {x:20, y:21}, {x:22, y:23}]},
                {values: [{x:66, y:66}, {x:666, y:666}, {x:6666, y:6666}, {x:66666, y:66666}]}
            ];
            (new MapChartMovieUpdater()).update(chart, newData);
            expect(updatedData).toEqual(chart.data);
        });
    });
});